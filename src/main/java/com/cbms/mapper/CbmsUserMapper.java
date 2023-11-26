package com.cbms.mapper;

import com.cbms.entity.CbmsUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Mapper
public interface CbmsUserMapper extends BaseMapper<CbmsUser> {
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    public CbmsUser selectCbmsUserById(Long id);

    /**
     * 查询用户列表
     *
     * @param cbmsUser 用户
     * @return 用户集合
     */
    public List<CbmsUser> selectCbmsUserList(CbmsUser cbmsUser);

    /**
     * 新增用户
     *
     * @param cbmsUser 用户
     * @return 结果
     */
    public int insertCbmsUser(CbmsUser cbmsUser);

    /**
     * 修改用户
     *
     * @param cbmsUser 用户
     * @return 结果
     */
    public int updateCbmsUser(CbmsUser cbmsUser);

    /**
     * 删除用户
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteCbmsUserById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbmsUserByIds(Long[] ids);
}
