package com.ruoyi.ctj.htgl.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 合同管理对象 ctj_contract_info
 * 
 * @author philorun
 * @date 2023-05-31
 */
public class CtjContractInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String htbh;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String htmc;

    /** 合同类型 */
    @Excel(name = "合同类型")
    private String htlx;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private Double htje;

    /** 起始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "起始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date qsrq;

    /** 终止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "终止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date zzrq;

    /** 签订日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date qdrq;

    /** 签订地点 */
    @Excel(name = "签订地点")
    private String qddd;

    /** 签订主体 */
    @Excel(name = "签订主体")
    private String qdzt;

    /** 关联项目 */
    @Excel(name = "关联项目")
    private String glxm;

    /** 合同状态 */
    @Excel(name = "合同状态")
    private String htzt;

    /** 执行进度 */
    @Excel(name = "执行进度")
    private Double zxjd;

    /** 合同描述 */
    @Excel(name = "合同描述")
    private String htms;

    /** 合同附件 */
    @Excel(name = "合同附件")
    private String htfj;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setHtbh(String htbh) 
    {
        this.htbh = htbh;
    }

    public String getHtbh() 
    {
        return htbh;
    }
    public void setHtmc(String htmc) 
    {
        this.htmc = htmc;
    }

    public String getHtmc() 
    {
        return htmc;
    }
    public void setHtlx(String htlx) 
    {
        this.htlx = htlx;
    }

    public String getHtlx() 
    {
        return htlx;
    }
    public void setHtje(Double htje) 
    {
        this.htje = htje;
    }

    public Double getHtje() 
    {
        return htje;
    }
    public void setQsrq(Date qsrq) 
    {
        this.qsrq = qsrq;
    }

    public Date getQsrq() 
    {
        return qsrq;
    }
    public void setZzrq(Date zzrq) 
    {
        this.zzrq = zzrq;
    }

    public Date getZzrq() 
    {
        return zzrq;
    }
    public void setQdrq(Date qdrq) 
    {
        this.qdrq = qdrq;
    }

    public Date getQdrq() 
    {
        return qdrq;
    }
    public void setQddd(String qddd) 
    {
        this.qddd = qddd;
    }

    public String getQddd() 
    {
        return qddd;
    }
    public void setQdzt(String qdzt) 
    {
        this.qdzt = qdzt;
    }

    public String getQdzt() 
    {
        return qdzt;
    }
    public void setGlxm(String glxm) 
    {
        this.glxm = glxm;
    }

    public String getGlxm() 
    {
        return glxm;
    }
    public void setHtzt(String htzt) 
    {
        this.htzt = htzt;
    }

    public String getHtzt() 
    {
        return htzt;
    }
    public void setZxjd(Double zxjd) 
    {
        this.zxjd = zxjd;
    }

    public Double getZxjd() 
    {
        return zxjd;
    }
    public void setHtms(String htms) 
    {
        this.htms = htms;
    }

    public String getHtms() 
    {
        return htms;
    }
    public void setHtfj(String htfj) 
    {
        this.htfj = htfj;
    }

    public String getHtfj() 
    {
        return htfj;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("htbh", getHtbh())
            .append("htmc", getHtmc())
            .append("htlx", getHtlx())
            .append("htje", getHtje())
            .append("qsrq", getQsrq())
            .append("zzrq", getZzrq())
            .append("qdrq", getQdrq())
            .append("qddd", getQddd())
            .append("qdzt", getQdzt())
            .append("glxm", getGlxm())
            .append("htzt", getHtzt())
            .append("zxjd", getZxjd())
            .append("htms", getHtms())
            .append("htfj", getHtfj())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
