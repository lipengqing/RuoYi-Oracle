package com.ruoyi.system.attachmentType.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntityS;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 附件类型对象 sys_attachment_type
 * 
 * @author philorun
 * @date 2023-06-05
 */
public class AttachmentType extends TreeEntityS {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 类型编码 */
    @Excel(name = "类型编码")
    private String typeCode;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String typeName;

    /** 所有级别排序号 */
    private String treeSorts;

    /** 是否最末级 */
    private String treeLeaf;

    /** 层次级别 */
    private String treeLevel;

    /** 节点全名称 */
    private String treeNames;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setTypeCode(String typeCode) 
    {
        this.typeCode = typeCode;
    }

    public String getTypeCode() 
    {
        return typeCode;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setTreeSorts(String treeSorts) 
    {
        this.treeSorts = treeSorts;
    }

    public String getTreeSorts() 
    {
        return treeSorts;
    }
    public void setTreeLeaf(String treeLeaf) 
    {
        this.treeLeaf = treeLeaf;
    }

    public String getTreeLeaf() 
    {
        return treeLeaf;
    }
    public void setTreeLevel(String treeLevel) 
    {
        this.treeLevel = treeLevel;
    }

    public String getTreeLevel() 
    {
        return treeLevel;
    }
    public void setTreeNames(String treeNames) 
    {
        this.treeNames = treeNames;
    }

    public String getTreeNames() 
    {
        return treeNames;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentId", getParentId())
            .append("typeCode", getTypeCode())
            .append("typeName", getTypeName())
            .append("orderNum", getOrderNum())
            .append("treeSorts", getTreeSorts())
            .append("treeLeaf", getTreeLeaf())
            .append("treeLevel", getTreeLevel())
            .append("ancestors", getAncestors())
            .append("treeNames", getTreeNames())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
