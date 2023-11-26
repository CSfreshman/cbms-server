package com.cbms.service;

import com.cbms.entity.CbmsOrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单明细表 服务类
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
public interface ICbmsOrderDetailService extends IService<CbmsOrderDetail> {
    /**
     * 查询订单明细
     *
     * @param id 订单明细主键
     * @return 订单明细
     */
    public CbmsOrderDetail selectCbmsOrderDetailById(Long id);

    /**
     * 查询订单明细列表
     *
     * @param cbmsOrderDetail 订单明细
     * @return 订单明细集合
     */
    public List<CbmsOrderDetail> selectCbmsOrderDetailList(CbmsOrderDetail cbmsOrderDetail);

    /**
     * 新增订单明细
     *
     * @param cbmsOrderDetail 订单明细
     * @return 结果
     */
    public int insertCbmsOrderDetail(CbmsOrderDetail cbmsOrderDetail);

    /**
     * 修改订单明细
     *
     * @param cbmsOrderDetail 订单明细
     * @return 结果
     */
    public int updateCbmsOrderDetail(CbmsOrderDetail cbmsOrderDetail);

    /**
     * 批量删除订单明细
     *
     * @param ids 需要删除的订单明细主键集合
     * @return 结果
     */
    public int deleteCbmsOrderDetailByIds(Long[] ids);

    /**
     * 删除订单明细信息
     *
     * @param id 订单明细主键
     * @return 结果
     */
    public int deleteCbmsOrderDetailById(Long id);
}

