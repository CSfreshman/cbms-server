package com.cbms.controller;

import com.cbms.core.AjaxResult;
import com.cbms.core.controller.BaseController;
import com.cbms.core.page.TableDataInfo;

import com.cbms.entity.CbmsOrderDetail;
import com.cbms.service.ICbmsOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单明细表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@RestController
@RequestMapping("/cbmsOrderDetail")
public class CbmsOrderDetailController extends BaseController {
    @Autowired
    private ICbmsOrderDetailService cbmsOrderDetailService;

    /**
     * 查询订单明细列表
     */
    @GetMapping("/list")
    public TableDataInfo list(CbmsOrderDetail cbmsOrderDetail)
    {
        startPage();
        List<CbmsOrderDetail> list = cbmsOrderDetailService.selectCbmsOrderDetailList(cbmsOrderDetail);
        return getDataTable(list);
    }


    /**
     * 获取订单明细详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbmsOrderDetailService.selectCbmsOrderDetailById(id));
    }

    /**
     * 新增订单明细
     */
    @PostMapping
    public AjaxResult add(@RequestBody CbmsOrderDetail cbmsOrderDetail)
    {
        return toAjax(cbmsOrderDetailService.insertCbmsOrderDetail(cbmsOrderDetail));
    }

    /**
     * 修改订单明细
     */
    @PutMapping
    public AjaxResult edit(@RequestBody CbmsOrderDetail cbmsOrderDetail)
    {
        return toAjax(cbmsOrderDetailService.updateCbmsOrderDetail(cbmsOrderDetail));
    }

    /**
     * 删除订单明细
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbmsOrderDetailService.deleteCbmsOrderDetailByIds(ids));
    }
}

