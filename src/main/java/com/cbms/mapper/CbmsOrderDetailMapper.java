package com.cbms.mapper;

import com.cbms.entity.CbmsOrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 订单明细表 Mapper 接口
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Mapper
public interface CbmsOrderDetailMapper extends BaseMapper<CbmsOrderDetail> {
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
     * 删除订单明细
     *
     * @param id 订单明细主键
     * @return 结果
     */
    public int deleteCbmsOrderDetailById(Long id);

    /**
     * 批量删除订单明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbmsOrderDetailByIds(Long[] ids);

}
