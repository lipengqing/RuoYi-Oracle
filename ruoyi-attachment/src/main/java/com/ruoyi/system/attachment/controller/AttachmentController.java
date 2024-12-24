package com.ruoyi.system.attachment.controller;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.attachment.domain.Attachment;
import com.ruoyi.system.attachment.service.IAttachmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 附件Controller
 * 
 * @author philorun
 * @date 2023-05-11
 */
@Controller
@RequestMapping("/system/attachment")
public class AttachmentController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(AttachmentController.class);

    private String prefix = "system/attachment";

    @Autowired
    private IAttachmentService attachmentService;

    @RequiresPermissions("system:attachment:view")
    @GetMapping("/listView")
    public String attachmentListView(Attachment attachment,ModelMap mmap) {
        mmap.put("attachment", attachment);
        return prefix + "/attachmentListView";
    }

    @RequiresPermissions("system:attachment:view")
    @GetMapping()
    public String attachment() {
        return prefix + "/attachmentList";
    }

    /**
     * 查询附件列表
     */
    @RequiresPermissions("system:attachment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Attachment attachment) {
        startPage();
        List<Attachment> list = attachmentService.selectAttachmentList(attachment);
        return getDataTable(list);
    }

    /**
     * 导出附件列表
     */
    @RequiresPermissions("system:attachment:export")
    @Log(title = "附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Attachment attachment) {
        List<Attachment> list = attachmentService.selectAttachmentList(attachment);
        ExcelUtil<Attachment> util = new ExcelUtil<>(Attachment.class);
        return util.exportExcel(list, "附件数据");
    }

    /**
     * 新增附件
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/attachmentAdd";
    }

    /**
     * 新增保存附件
     */
    @RequiresPermissions("system:attachment:add")
    @Log(title = "附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Attachment attachment) {
        return toAjax(attachmentService.insertAttachment(attachment));
    }

    /**
     * 修改附件
     */
    @RequiresPermissions("system:attachment:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Attachment attachment = attachmentService.selectAttachmentById(id);
        mmap.put("attachment", attachment);
        return prefix + "/attachmentEdit";
    }

    /**
     * 修改保存附件
     */
    @RequiresPermissions("system:attachment:edit")
    @Log(title = "附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Attachment attachment) {
        return toAjax(attachmentService.updateAttachment(attachment));
    }

    /**
     * 删除附件
     */
    @RequiresPermissions("system:attachment:remove")
    @Log(title = "附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(attachmentService.deleteAttachmentByIds(ids));
    }


    /**  引用页面功能 start */
    /**
     * 加载
     * @param attachment
     * @return
     */
    @PostMapping("/load")
    @ResponseBody
    public String load(Attachment attachment) {
        List<Attachment> alist = attachmentService.selectAttachmentList(attachment);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        jsonObject.put("alist", alist);
        return jsonObject.toString();
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String ids) {
        try {
            return toAjax(attachmentService.deleteAttachmentByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 保存
     * @param attachment
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(Attachment attachment) {
        return toAjax(attachmentService.insertAttachment(attachment));
    }
    /**  引用页面功能 end */

    /**
     * 附件上传
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam MultipartFile file) {
        JSONObject json = new JSONObject();
        if(file!=null){
            try {
                //上传文件，返回文件名
                String fileName = FileUploadUtils.upload(RuoYiConfig.getUploadPath(), file);//

                //拼装文件名、文件路径信息，返回json
                json.put("success", true);
                json.put("filePath", RuoYiConfig.getUploadPath() + fileName.replace("/profile/upload", ""));
                json.put("fileNameReal", fileName);
                json.put("fileNameShow", file.getOriginalFilename());
                json.put("fileSize", file.getSize());
                return json.toString();

            } catch (IOException e) {

                json.put("success", false);
                json.put("msg", "上传失败!");
                return json.toString();
            }

        }else {
            json.put("success", false);
            json.put("msg", "请选择附件！");
            return json.toString();
        }
    }


    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("/download")
    public void download(String fileName, String fileNameReal, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        try {
            if (!FileUtils.checkAllowDownload(fileName)) {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String filePath = RuoYiConfig.getUploadPath() + fileNameReal.replace("/profile/upload", "");

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, fileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 附件上传通用页面
     * @param attachment
     * @param modelMap
     * @return
     */
    @GetMapping("/attachmentUpload")
    public String attachmentUpload(Attachment attachment, ModelMap modelMap) {
        modelMap.put("attachment", attachment);
        return prefix + "/attachmentUpload";
    }
}
