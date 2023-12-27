package com.cbms.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cbms.config.AlipayConfig;
import com.cbms.core.AjaxResult;
import com.cbms.entity.CbmsOrder;
import com.cbms.service.ICbmsOrderService;
import com.cbms.util.PayUtil;
import com.cbms.util.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alipay")
public class AlipayController {

    @Autowired
    private ICbmsOrderService orderService;

    // 支付成功同步回调
    @GetMapping("/return")
    public String successReturn(){
        return "return.html";
    }

    // 支付成功异步回调
    @PostMapping("/notify")
    public String alipayNotify(HttpServletRequest request){
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        Map<String, String> paramsMap = new HashMap<>(); //将异步通知中收到的所有参数都存放到map中

        for (String s : requestParameterMap.keySet()) {
            paramsMap.put(s,requestParameterMap.get(s)[0]);
            System.out.println(s + "--" + paramsMap.get(s));
        }


        boolean signVerified = false; //调用SDK验证签名
        try {
            signVerified = AlipaySignature.rsaCheckV1(paramsMap, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(signVerified){
            // TODO 验签成功后，按照支付结果异步通知中的描述，对支付结果中的业务内容进行二次校验，校验成功后在response中返回success并继续商户自身业务处理，校验失败返回failure
            System.out.println("异步通知验签通过");


            String myOrderCode = paramsMap.get("out_trade_no");
            CbmsOrder order = orderService.getOne(new LambdaQueryWrapper<CbmsOrder>().eq(CbmsOrder::getCode, myOrderCode));

            // 支付宝支付
            order.setPayType(1);

            // 交易支付成功（可退款） 以及 交易完成状态
            if("TRADE_SUCCESS".equals(paramsMap.get("trade_status")) || "TRADE_FINISHED".equals(paramsMap.get("trade_status"))){
                // 支付完成状态
                order.setPayState(3);
                order.setPayCode("2023112922001494330501542289");

            }else{
                // 取消状态
                order.setPayState(4);
            }
            // 设置更新时间
            order.setUpdateTime(DateUtils.getNowDate());
            orderService.updateById(order);

            return "success";
        }else{
            // TODO 验签失败则记录异常日志，并在response中返回failure.
        }
        return "failure";
    }

    @ResponseBody
    @PostMapping("/query")
    public AjaxResult query(@RequestBody PayReq req){
        System.out.println("查询订单状态"+req);
        String payState = PayUtil.queryPayState(req.getOutTradeNo(), req.getTradeNo(), req.getQueryOptions());
        System.out.println(payState);
        return AjaxResult.success(payState);
    }
}
