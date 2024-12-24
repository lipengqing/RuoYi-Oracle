package com.ruoyi.system.attachmentType.service.impl;

import com.ruoyi.common.core.domain.ZtreeS;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.attachmentType.domain.AttachmentType;
import com.ruoyi.system.attachmentType.mapper.AttachmentTypeMapper;
import com.ruoyi.system.attachmentType.service.IAttachmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 附件类型Service业务层处理
 * 
 * @author philorun
 * @date 2023-06-05
 */
@Service
public class AttachmentTypeServiceImpl implements IAttachmentTypeService {
    @Autowired
    private AttachmentTypeMapper attachmentTypeMapper;

    /**
     * 查询附件类型
     * 
     * @param id 附件类型主键
     * @return 附件类型
     */
    @Override
    public AttachmentType selectAttachmentTypeById(String id) {
        return attachmentTypeMapper.selectAttachmentTypeById(id);
    }

    /**
     * 查询附件类型列表
     * 
     * @param attachmentType 附件类型
     * @return 附件类型
     */
    @Override
    public List<AttachmentType> selectAttachmentTypeList(AttachmentType attachmentType) {
        return attachmentTypeMapper.selectAttachmentTypeList(attachmentType);
    }

    /**
     * 新增附件类型
     * 
     * @param attachmentType 附件类型
     * @return 结果
     */
    @Override
    public int insertAttachmentType(AttachmentType attachmentType) {
        attachmentType.setCreateTime(DateUtils.getNowDate());
        return attachmentTypeMapper.insertAttachmentType(attachmentType);
    }

    /**
     * 修改附件类型
     * 
     * @param attachmentType 附件类型
     * @return 结果
     */
    @Override
    public int updateAttachmentType(AttachmentType attachmentType) {
        attachmentType.setUpdateTime(DateUtils.getNowDate());
        return attachmentTypeMapper.updateAttachmentType(attachmentType);
    }

    /**
     * 批量删除附件类型
     * 
     * @param ids 需要删除的附件类型主键
     * @return 结果
     */
    @Override
    public int deleteAttachmentTypeByIds(String ids) {
        return attachmentTypeMapper.deleteAttachmentTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除附件类型信息
     * 
     * @param id 附件类型主键
     * @return 结果
     */
    @Override
    public int deleteAttachmentTypeById(String id) {
        return attachmentTypeMapper.deleteAttachmentTypeById(id);
    }

    /**
     * 查询附件类型树列表
     * 
     * @return 所有附件类型信息
     */
    @Override
    public List<ZtreeS> selectAttachmentTypeTree() {
        List<AttachmentType> attachmentTypeList = attachmentTypeMapper.selectAttachmentTypeList(new AttachmentType());
        List<ZtreeS> ztrees = new ArrayList<>();
        for (AttachmentType attachmentType : attachmentTypeList)
        {
            ZtreeS ztree = new ZtreeS();
            ztree.setId(attachmentType.getId());
            ztree.setpId(attachmentType.getParentId());
            ztree.setName(attachmentType.getTypeName());
            ztree.setTitle(attachmentType.getTypeName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    /**
     * 校验类型编码是否唯一
     *
     * @param typeCode 类型编码
     * @return
     */
    @Override
    public String checkTypeCodeUnique(String typeCode) {
        int count = attachmentTypeMapper.checkTypeCodeUnique(typeCode);
        if (count > 0) {
            return "1";//不唯一
        }
        return "0";//唯一
    }
}
