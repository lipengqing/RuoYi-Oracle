package com.ruoyi.system.attachment.service;

import java.util.List;
import com.ruoyi.system.attachment.domain.Attachment;

/**
 * 附件Service接口
 * 
 * @author philorun
 * @date 2023-05-11
 */
public interface IAttachmentService {
    /**
     * 查询附件
     * 
     * @param id 附件主键
     * @return 附件
     */
    Attachment selectAttachmentById(String id);

    /**
     * 查询附件列表
     * 
     * @param attachment 附件
     * @return 附件集合
     */
    List<Attachment> selectAttachmentList(Attachment attachment);

    /**
     * 新增附件
     * 
     * @param attachment 附件
     * @return 结果
     */
    int insertAttachment(Attachment attachment);

    /**
     * 修改附件
     * 
     * @param attachment 附件
     * @return 结果
     */
    int updateAttachment(Attachment attachment);

    /**
     * 批量删除附件
     * 
     * @param ids 需要删除的附件主键集合
     * @return 结果
     */
    int deleteAttachmentByIds(String ids);

    /**
     * 删除附件信息
     * 
     * @param id 附件主键
     * @return 结果
     */
    int deleteAttachmentById(String id);
}
