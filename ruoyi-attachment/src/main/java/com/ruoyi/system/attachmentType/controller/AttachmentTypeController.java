package com.ruoyi.system.attachmentType.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.ZtreeS;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.attachmentType.domain.AttachmentType;
import com.ruoyi.system.attachmentType.service.IAttachmentTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 附件类型Controller
 * 
 * @author philorun
 * @date 2023-06-05
 */
@Controller
@RequestMapping("/system/attachmentType")
public class AttachmentTypeController extends BaseController {
    private String prefix = "system/attachmentType";

    @Autowired
    private IAttachmentTypeService attachmentTypeService;

    @RequiresPermissions("system:attachmentType:view")
    @GetMapping()
    public String attachmentType() {
        return prefix + "/attachmentTypeList";
    }

    /**
     * 查询附件类型树列表
     */
    @RequiresPermissions("system:attachmentType:list")
    @PostMapping("/list")
    @ResponseBody
    public List<AttachmentType> list(AttachmentType attachmentType) {
        List<AttachmentType> list = attachmentTypeService.selectAttachmentTypeList(attachmentType);
        return list;
    }

    /**
     * 导出附件类型列表
     */
    @RequiresPermissions("system:attachmentType:export")
    @Log(title = "附件类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AttachmentType attachmentType) {
        List<AttachmentType> list = attachmentTypeService.selectAttachmentTypeList(attachmentType);
        ExcelUtil<AttachmentType> util = new ExcelUtil<>(AttachmentType.class);
        return util.exportExcel(list, "附件类型数据");
    }

    /**
     * 新增附件类型
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) String id, ModelMap mmap) {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("attachmentType", attachmentTypeService.selectAttachmentTypeById(id));
        }
        return prefix + "/attachmentTypeAdd";
    }

    /**
     * 新增保存附件类型
     */
    @RequiresPermissions("system:attachmentType:add")
    @Log(title = "附件类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AttachmentType attachmentType) {
        return toAjax(attachmentTypeService.insertAttachmentType(attachmentType));
    }

    /**
     * 修改附件类型
     */
    @RequiresPermissions("system:attachmentType:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        AttachmentType attachmentType = attachmentTypeService.selectAttachmentTypeById(id);
        mmap.put("attachmentType", attachmentType);
        return prefix + "/attachmentTypeEdit";
    }

    /**
     * 修改保存附件类型
     */
    @RequiresPermissions("system:attachmentType:edit")
    @Log(title = "附件类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AttachmentType attachmentType) {
        return toAjax(attachmentTypeService.updateAttachmentType(attachmentType));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:attachmentType:remove")
    @Log(title = "附件类型", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") String id) {
        return toAjax(attachmentTypeService.deleteAttachmentTypeById(id));
    }

    /**
     * 选择附件类型树
     */
    @GetMapping(value = { "/selectAttachmentTypeTree/{id}", "/selectAttachmentTypeTree/" })
    public String selectAttachmentTypeTree(@PathVariable(value = "id", required = false) String id, ModelMap mmap) {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("attachmentType", attachmentTypeService.selectAttachmentTypeById(id));
        }
        return prefix + "/attachmentTypeTree";
    }

    /**
     * 加载附件类型树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<ZtreeS> treeData() {
        List<ZtreeS> ztrees = attachmentTypeService.selectAttachmentTypeTree();
        return ztrees;
    }

    /**
     * 校验类型编码
     */
    @PostMapping("/checkTypeCodeUnique")
    @ResponseBody
    public String checkTypeCodeUnique(AttachmentType attachmentType) {
        return attachmentTypeService.checkTypeCodeUnique(attachmentType.getTypeCode());
    }
}
