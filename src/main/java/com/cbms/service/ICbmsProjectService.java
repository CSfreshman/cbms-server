package com.cbms.service;

import com.cbms.entity.CbmsProject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 美容项目表 服务类
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
public interface ICbmsProjectService extends IService<CbmsProject> {
    /**
     * 查询美容项目
     *
     * @param id 美容项目主键
     * @return 美容项目
     */
    public CbmsProject selectCbmsProjectById(Long id);

    /**
     * 查询美容项目列表
     *
     * @param cbmsProject 美容项目
     * @return 美容项目集合
     */
    public List<CbmsProject> selectCbmsProjectList(CbmsProject cbmsProject);

    /**
     * 新增美容项目
     *
     * @param cbmsProject 美容项目
     * @return 结果
     */
    public int insertCbmsProject(CbmsProject cbmsProject);

    /**
     * 修改美容项目
     *
     * @param cbmsProject 美容项目
     * @return 结果
     */
    public int updateCbmsProject(CbmsProject cbmsProject);

    /**
     * 批量删除美容项目
     *
     * @param ids 需要删除的美容项目主键集合
     * @return 结果
     */
    public int deleteCbmsProjectByIds(Long[] ids);

    /**
     * 删除美容项目信息
     *
     * @param id 美容项目主键
     * @return 结果
     */
    public int deleteCbmsProjectById(Long id);
}
