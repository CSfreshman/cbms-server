package com.cbms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/alipay")
public class AlipayController {


    // 支付成功同步回调
    @GetMapping("/return.html")
    public String successReturn(){
        return "/return.html";
    }

    // 支付成功异步回调
    @PostMapping("/notify")
    public String alipayNotify(HttpServletRequest request){
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : map.entrySet()) {
            System.out.println(stringEntry.getKey() + "--" + stringEntry.getValue());
        }
        return "success";
    }

}
