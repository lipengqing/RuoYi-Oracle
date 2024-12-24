package com.ruoyi.ctj.htgl.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.ctj.htgl.domain.CtjContractInfo;
import com.ruoyi.ctj.htgl.service.ICtjContractInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 合同管理Controller
 * 
 * @author philorun
 * @date 2023-05-31
 */
@Controller
@RequestMapping("/ctj/htgl")
public class CtjContractInfoController extends BaseController {
    private String prefix = "ctj/htgl";

    @Autowired
    private ICtjContractInfoService ctjContractInfoService;

    @RequiresPermissions("ctj:htgl:view")
    @GetMapping()
    public String htgl() {
        return prefix + "/htglList";
    }

    /**
     * 查询合同管理列表
     */
    @RequiresPermissions("ctj:htgl:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CtjContractInfo ctjContractInfo) {
        startPage();
        List<CtjContractInfo> list = ctjContractInfoService.selectCtjContractInfoList(ctjContractInfo);
        return getDataTable(list);
    }

    /**
     * 导出合同管理列表
     */
    @RequiresPermissions("ctj:htgl:export")
    @Log(title = "合同管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CtjContractInfo ctjContractInfo) {
        List<CtjContractInfo> list = ctjContractInfoService.selectCtjContractInfoList(ctjContractInfo);
        ExcelUtil<CtjContractInfo> util = new ExcelUtil<>(CtjContractInfo.class);
        return util.exportExcel(list, "合同管理数据");
    }

    /**
     * 新增合同管理
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/htglAdd";
    }

    /**
     * 新增保存合同管理
     */
    @RequiresPermissions("ctj:htgl:add")
    @Log(title = "合同管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CtjContractInfo ctjContractInfo, ModelMap mmap) {
        if(null == ctjContractInfo.getId())
            ctjContractInfo.setId(IdUtils.fastSimpleUUID());
        mmap.put("ctjContractInfo",ctjContractInfo);
        ctjContractInfoService.insertCtjContractInfo(ctjContractInfo);
        return success(ctjContractInfo);
    }

    /**
     * 修改合同管理
     */
    @RequiresPermissions("ctj:htgl:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        CtjContractInfo ctjContractInfo = ctjContractInfoService.selectCtjContractInfoById(id);
        mmap.put("ctjContractInfo", ctjContractInfo);
        return prefix + "/htglEdit";
    }

    /**
     * 修改保存合同管理
     */
    @RequiresPermissions("ctj:htgl:edit")
    @Log(title = "合同管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CtjContractInfo ctjContractInfo) {
        return toAjax(ctjContractInfoService.updateCtjContractInfo(ctjContractInfo));
    }

    /**
     * 删除合同管理
     */
    @RequiresPermissions("ctj:htgl:remove")
    @Log(title = "合同管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(ctjContractInfoService.deleteCtjContractInfoByIds(ids));
    }
}
