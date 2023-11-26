package com.cbms.controller;

import com.cbms.core.AjaxResult;
import com.cbms.core.controller.BaseController;
import com.cbms.core.page.TableDataInfo;
import com.cbms.entity.CbmsOrder;
import com.cbms.service.ICbmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 订单主表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@RestController
@RequestMapping("/cbmsOrder")
public class CbmsOrderController extends BaseController {

    @Autowired
    private ICbmsOrderService cbmsOrderService;

    /**
     * 查询订单主列表
     */
    @GetMapping("/list")
    public TableDataInfo list(CbmsOrder cbmsOrder) {
        startPage();
        List<CbmsOrder> list = cbmsOrderService.selectCbmsOrderList(cbmsOrder);
        return getDataTable(list);
    }

    /**
     * 获取订单主详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(cbmsOrderService.selectCbmsOrderById(id));
    }

    /**
     * 新增订单主
     */
    @PostMapping
    public AjaxResult add(@RequestBody CbmsOrder cbmsOrder) {
        return toAjax(cbmsOrderService.insertCbmsOrder(cbmsOrder));
    }

    /**
     * 修改订单主
     */
    @PutMapping
    public AjaxResult edit(@RequestBody CbmsOrder cbmsOrder) {
        return toAjax(cbmsOrderService.updateCbmsOrder(cbmsOrder));
    }

    /**
     * 删除订单主
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(cbmsOrderService.deleteCbmsOrderByIds(ids));
    }
}
