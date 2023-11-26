package com.cbms.mapper;

import com.cbms.entity.CbmsProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 美容项目表 Mapper 接口
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Mapper
public interface CbmsProjectMapper extends BaseMapper<CbmsProject> {
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
     * 删除美容项目
     *
     * @param id 美容项目主键
     * @return 结果
     */
    public int deleteCbmsProjectById(Long id);

    /**
     * 批量删除美容项目
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbmsProjectByIds(Long[] ids);
}
