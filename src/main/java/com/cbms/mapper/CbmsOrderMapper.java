package com.cbms.mapper;

import com.cbms.entity.CbmsOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 订单主表 Mapper 接口
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Mapper
public interface CbmsOrderMapper extends BaseMapper<CbmsOrder> {
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
     * 删除订单主
     *
     * @param id 订单主主键
     * @return 结果
     */
    public int deleteCbmsOrderById(Long id);

    /**
     * 批量删除订单主
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbmsOrderByIds(Long[] ids);
}
