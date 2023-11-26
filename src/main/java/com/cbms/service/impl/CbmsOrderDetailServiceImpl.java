package com.cbms.service.impl;

import com.cbms.entity.CbmsOrderDetail;
import com.cbms.mapper.CbmsOrderDetailMapper;
import com.cbms.service.ICbmsOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cbms.util.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Service
public class CbmsOrderDetailServiceImpl extends ServiceImpl<CbmsOrderDetailMapper, CbmsOrderDetail> implements ICbmsOrderDetailService {
    @Autowired
    private CbmsOrderDetailMapper cbmsOrderDetailMapper;

    /**
     * 查询订单明细
     *
     * @param id 订单明细主键
     * @return 订单明细
     */
    @Override
    public CbmsOrderDetail selectCbmsOrderDetailById(Long id)
    {
        return cbmsOrderDetailMapper.selectCbmsOrderDetailById(id);
    }

    /**
     * 查询订单明细列表
     *
     * @param cbmsOrderDetail 订单明细
     * @return 订单明细
     */
    @Override
    public List<CbmsOrderDetail> selectCbmsOrderDetailList(CbmsOrderDetail cbmsOrderDetail)
    {
        return cbmsOrderDetailMapper.selectCbmsOrderDetailList(cbmsOrderDetail);
    }

    /**
     * 新增订单明细
     *
     * @param cbmsOrderDetail 订单明细
     * @return 结果
     */
    @Override
    public int insertCbmsOrderDetail(CbmsOrderDetail cbmsOrderDetail)
    {
        cbmsOrderDetail.setCreateTime(DateUtils.getNowDate());
        return cbmsOrderDetailMapper.insertCbmsOrderDetail(cbmsOrderDetail);
    }

    /**
     * 修改订单明细
     *
     * @param cbmsOrderDetail 订单明细
     * @return 结果
     */
    @Override
    public int updateCbmsOrderDetail(CbmsOrderDetail cbmsOrderDetail)
    {
        return cbmsOrderDetailMapper.updateCbmsOrderDetail(cbmsOrderDetail);
    }

    /**
     * 批量删除订单明细
     *
     * @param ids 需要删除的订单明细主键
     * @return 结果
     */
    @Override
    public int deleteCbmsOrderDetailByIds(Long[] ids)
    {
        return cbmsOrderDetailMapper.deleteCbmsOrderDetailByIds(ids);
    }

    /**
     * 删除订单明细信息
     *
     * @param id 订单明细主键
     * @return 结果
     */
    @Override
    public int deleteCbmsOrderDetailById(Long id)
    {
        return cbmsOrderDetailMapper.deleteCbmsOrderDetailById(id);
    }
}

