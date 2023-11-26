package com.cbms.service.impl;

import cn.hutool.core.util.IdUtil;
import com.cbms.entity.CbmsProject;
import com.cbms.mapper.CbmsProjectMapper;
import com.cbms.service.ICbmsProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 美容项目表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Service
public class CbmsProjectServiceImpl extends ServiceImpl<CbmsProjectMapper, CbmsProject> implements ICbmsProjectService {
    @Autowired
    private CbmsProjectMapper cbmsProjectMapper;

    /**
     * 查询美容项目
     *
     * @param id 美容项目主键
     * @return 美容项目
     */
    @Override
    public CbmsProject selectCbmsProjectById(Long id)
    {
        return cbmsProjectMapper.selectCbmsProjectById(id);
    }

    /**
     * 查询美容项目列表
     *
     * @param cbmsProject 美容项目
     * @return 美容项目
     */
    @Override
    public List<CbmsProject> selectCbmsProjectList(CbmsProject cbmsProject)
    {
        return cbmsProjectMapper.selectCbmsProjectList(cbmsProject);
    }

    /**
     * 新增美容项目
     *
     * @param cbmsProject 美容项目
     * @return 结果
     */
    @Override
    public int insertCbmsProject(CbmsProject cbmsProject)
    {
        cbmsProject.setId(IdUtil.getSnowflakeNextId());
        return cbmsProjectMapper.insertCbmsProject(cbmsProject);
    }

    /**
     * 修改美容项目
     *
     * @param cbmsProject 美容项目
     * @return 结果
     */
    @Override
    public int updateCbmsProject(CbmsProject cbmsProject)
    {
        return cbmsProjectMapper.updateCbmsProject(cbmsProject);
    }

    /**
     * 批量删除美容项目
     *
     * @param ids 需要删除的美容项目主键
     * @return 结果
     */
    @Override
    public int deleteCbmsProjectByIds(Long[] ids)
    {
        return cbmsProjectMapper.deleteCbmsProjectByIds(ids);
    }

    /**
     * 删除美容项目信息
     *
     * @param id 美容项目主键
     * @return 结果
     */
    @Override
    public int deleteCbmsProjectById(Long id)
    {
        return cbmsProjectMapper.deleteCbmsProjectById(id);
    }
}
