package com.cbms.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cbms.entity.CbmsUser;
import com.cbms.mapper.CbmsUserMapper;
import com.cbms.service.ICbmsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Service
public class CbmsUserServiceImpl extends ServiceImpl<CbmsUserMapper, CbmsUser> implements ICbmsUserService {
    @Autowired
    private CbmsUserMapper cbmsUserMapper;

    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public CbmsUser selectCbmsUserById(Long id)
    {
        return cbmsUserMapper.selectCbmsUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param cbmsUser 用户
     * @return 用户
     */
    @Override
    public List<CbmsUser> selectCbmsUserList(CbmsUser cbmsUser)
    {
        return cbmsUserMapper.selectCbmsUserList(cbmsUser);
    }

    /**
     * 新增用户
     *
     * @param cbmsUser 用户
     * @return 结果
     */
    @Override
    public int insertCbmsUser(CbmsUser cbmsUser)
    {
        CbmsUser byPhone = cbmsUserMapper.selectOne(new LambdaQueryWrapper<CbmsUser>().eq(CbmsUser::getPhone, cbmsUser.getPhone()));
        if(ObjectUtil.isNotNull(byPhone)){
            return -1;
        }
        cbmsUser.setId(IdUtil.getSnowflakeNextId());
        return cbmsUserMapper.insertCbmsUser(cbmsUser);
    }

    /**
     * 修改用户
     *
     * @param cbmsUser 用户
     * @return 结果
     */
    @Override
    public int updateCbmsUser(CbmsUser cbmsUser)
    {
        return cbmsUserMapper.updateCbmsUser(cbmsUser);
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteCbmsUserByIds(Long[] ids)
    {
        return cbmsUserMapper.deleteCbmsUserByIds(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteCbmsUserById(Long id)
    {
        return cbmsUserMapper.deleteCbmsUserById(id);
    }
}
