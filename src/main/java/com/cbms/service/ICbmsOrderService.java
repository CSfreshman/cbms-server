package com.cbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cbms.entity.CbmsOrder;

import java.util.List;

/**
 * <p>
 * 订单主表 服务类
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
public interface ICbmsOrderService extends IService<CbmsOrder> {
    /**
     * 查询订单主
     *
     * @param id 订单主主键
     * @return 订单主
     */
    public CbmsOrder selectCbmsOrderById(Long id);

    /**
     * 查询订单主列表
     *
     * @param cbmsOrder 订单主
     * @return 订单主集合
     */
    public List<CbmsOrder> selectCbmsOrderList(CbmsOrder cbmsOrder);

    /**
     * 新增订单主
     *
     * @param cbmsOrder 订单主
     * @return 结果
     */
    public int insertCbmsOrder(CbmsOrder cbmsOrder);

    /**
     * 修改订单主
     *
     * @param cbmsOrder 订单主
     * @return 结果
     */
    public int updateCbmsOrder(CbmsOrder cbmsOrder);

    /**
     * 批量删除订单主
     *
     * @param ids 需要删除的订单主主键集合
     * @return 结果
     */
    public int deleteCbmsOrderByIds(Long[] ids);

    /**
     * 删除订单主信息
     *
     * @param id 订单主主键
     * @return 结果
     */
    public int deleteCbmsOrderById(Long id);
}
