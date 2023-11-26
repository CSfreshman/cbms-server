package com.cbms.controller;

import com.cbms.core.AjaxResult;
import com.cbms.core.controller.BaseController;
import com.cbms.core.page.TableDataInfo;
import com.cbms.entity.CbmsUser;
import com.cbms.service.ICbmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@RestController
@RequestMapping("/cbmsUser")
public class CbmsUserController extends BaseController{
    @Autowired
    private ICbmsUserService cbmsUserService;

    /**
     * 查询用户列表
     */
    @GetMapping("/list")
    public TableDataInfo list(CbmsUser cbmsUser)
    {
        startPage();
        List<CbmsUser> list = cbmsUserService.selectCbmsUserList(cbmsUser);
        return getDataTable(list);
    }


    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbmsUserService.selectCbmsUserById(id));
    }

    /**
     * 新增用户
     */

    @PostMapping
    public AjaxResult add(@RequestBody CbmsUser cbmsUser)
    {
        return toAjax(cbmsUserService.insertCbmsUser(cbmsUser));
    }

    /**
     * 修改用户
     */

    @PutMapping
    public AjaxResult edit(@RequestBody CbmsUser cbmsUser)
    {
        return toAjax(cbmsUserService.updateCbmsUser(cbmsUser));
    }

    /**
     * 删除用户
     */

    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbmsUserService.deleteCbmsUserByIds(ids));
    }
}
