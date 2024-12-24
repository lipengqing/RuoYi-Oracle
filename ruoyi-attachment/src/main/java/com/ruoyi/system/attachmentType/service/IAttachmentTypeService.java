package com.ruoyi.system.attachmentType.service;

import com.ruoyi.common.core.domain.ZtreeS;
import com.ruoyi.system.attachmentType.domain.AttachmentType;

import java.util.List;

/**
 * 附件类型Service接口
 * 
 * @author philorun
 * @date 2023-06-05
 */
public interface IAttachmentTypeService {
    /**
     * 查询附件类型
     * 
     * @param id 附件类型主键
     * @return 附件类型
     */
    AttachmentType selectAttachmentTypeById(String id);

    /**
     * 查询附件类型列表
     * 
     * @param attachmentType 附件类型
     * @return 附件类型集合
     */
    List<AttachmentType> selectAttachmentTypeList(AttachmentType attachmentType);

    /**
     * 新增附件类型
     * 
     * @param attachmentType 附件类型
     * @return 结果
     */
    int insertAttachmentType(AttachmentType attachmentType);

    /**
     * 修改附件类型
     * 
     * @param attachmentType 附件类型
     * @return 结果
     */
    int updateAttachmentType(AttachmentType attachmentType);

    /**
     * 批量删除附件类型
     * 
     * @param ids 需要删除的附件类型主键集合
     * @return 结果
     */
    int deleteAttachmentTypeByIds(String ids);

    /**
     * 删除附件类型信息
     * 
     * @param id 附件类型主键
     * @return 结果
     */
    int deleteAttachmentTypeById(String id);

    /**
     * 查询附件类型树列表
     * 
     * @return 所有附件类型信息
     */
    List<ZtreeS> selectAttachmentTypeTree();

    /**
     * 校验类型编码是否唯一
     *
     * @param typeCode 类型编码
     * @return 结果
     */
    String checkTypeCodeUnique(String typeCode);
}
