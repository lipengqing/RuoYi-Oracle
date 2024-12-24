package com.ruoyi.system.attachment.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.attachment.mapper.AttachmentMapper;
import com.ruoyi.system.attachment.domain.Attachment;
import com.ruoyi.system.attachment.service.IAttachmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 附件Service业务层处理
 * 
 * @author philorun
 * @date 2023-05-11
 */
@Service
public class AttachmentServiceImpl implements IAttachmentService 
{
    @Autowired
    private AttachmentMapper attachmentMapper;

    /**
     * 查询附件
     * 
     * @param id 附件主键
     * @return 附件
     */
    @Override
    public Attachment selectAttachmentById(String id)
    {
        return attachmentMapper.selectAttachmentById(id);
    }

    /**
     * 查询附件列表
     * 
     * @param attachment 附件
     * @return 附件
     */
    @Override
    public List<Attachment> selectAttachmentList(Attachment attachment)
    {
        return attachmentMapper.selectAttachmentList(attachment);
    }

    /**
     * 新增附件
     * 
     * @param attachment 附件
     * @return 结果
     */
    @Override
    public int insertAttachment(Attachment attachment)
    {
        attachment.setCreateTime(DateUtils.getNowDate());
        return attachmentMapper.insertAttachment(attachment);
    }

    /**
     * 修改附件
     * 
     * @param attachment 附件
     * @return 结果
     */
    @Override
    public int updateAttachment(Attachment attachment)
    {
        return attachmentMapper.updateAttachment(attachment);
    }

    /**
     * 批量删除附件
     * 
     * @param ids 需要删除的附件主键
     * @return 结果
     */
    @Override
    public int deleteAttachmentByIds(String ids)
    {
        return attachmentMapper.deleteAttachmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除附件信息
     * 
     * @param id 附件主键
     * @return 结果
     */
    @Override
    public int deleteAttachmentById(String id)
    {
        return attachmentMapper.deleteAttachmentById(id);
    }
}
