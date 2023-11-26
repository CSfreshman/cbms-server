package com.cbms.controller;

import com.cbms.core.AjaxResult;
import com.cbms.core.controller.BaseController;
import com.cbms.core.page.TableDataInfo;
import com.cbms.entity.CbmsProject;
import com.cbms.service.ICbmsProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 美容项目表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@RestController
@RequestMapping("/cbmsProject")
public class CbmsProjectController extends BaseController {

    @Autowired
    private ICbmsProjectService cbmsProjectService;

    /**
     * 查询美容项目列表
     */
    @GetMapping("/list")
    public TableDataInfo list(CbmsProject cbmsProject)
    {
        startPage();
        List<CbmsProject> list = cbmsProjectService.selectCbmsProjectList(cbmsProject);
        return getDataTable(list);
    }

    /**
     * 获取美容项目详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbmsProjectService.selectCbmsProjectById(id));
    }

    /**
     * 新增美容项目
     */
    @PostMapping
    public AjaxResult add(@RequestBody CbmsProject cbmsProject)
    {
        return toAjax(cbmsProjectService.insertCbmsProject(cbmsProject));
    }

    /**
     * 修改美容项目
     */
    @PutMapping
    public AjaxResult edit(@RequestBody CbmsProject cbmsProject)
    {
        return toAjax(cbmsProjectService.updateCbmsProject(cbmsProject));
    }

    /**
     * 删除美容项目
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbmsProjectService.deleteCbmsProjectByIds(ids));
    }
}
