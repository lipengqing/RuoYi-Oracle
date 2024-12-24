package com.ruoyi.ctj.htgl.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.ctj.htgl.domain.CtjContractInfo;
import com.ruoyi.ctj.htgl.mapper.CtjContractInfoMapper;
import com.ruoyi.ctj.htgl.service.ICtjContractInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 合同管理Service业务层处理
 * 
 * @author philorun
 * @date 2023-05-31
 */
@Service
public class CtjContractInfoServiceImpl implements ICtjContractInfoService
{
    @Autowired
    private CtjContractInfoMapper ctjContractInfoMapper;

    /**
     * 查询合同管理
     * 
     * @param id 合同管理主键
     * @return 合同管理
     */
    @Override
    public CtjContractInfo selectCtjContractInfoById(String id)
    {
        return ctjContractInfoMapper.selectCtjContractInfoById(id);
    }

    /**
     * 查询合同管理列表
     * 
     * @param ctjContractInfo 合同管理
     * @return 合同管理
     */
    @Override
    public List<CtjContractInfo> selectCtjContractInfoList(CtjContractInfo ctjContractInfo)
    {
        return ctjContractInfoMapper.selectCtjContractInfoList(ctjContractInfo);
    }

    /**
     * 新增合同管理
     * 
     * @param ctjContractInfo 合同管理
     * @return 结果
     */
    @Override
    public int insertCtjContractInfo(CtjContractInfo ctjContractInfo)
    {
        ctjContractInfo.setCreateTime(DateUtils.getNowDate());
        return ctjContractInfoMapper.insertCtjContractInfo(ctjContractInfo);
    }

    /**
     * 修改合同管理
     * 
     * @param ctjContractInfo 合同管理
     * @return 结果
     */
    @Override
    public int updateCtjContractInfo(CtjContractInfo ctjContractInfo)
    {
        ctjContractInfo.setUpdateTime(DateUtils.getNowDate());
        return ctjContractInfoMapper.updateCtjContractInfo(ctjContractInfo);
    }

    /**
     * 批量删除合同管理
     * 
     * @param ids 需要删除的合同管理主键
     * @return 结果
     */
    @Override
    public int deleteCtjContractInfoByIds(String ids)
    {
        return ctjContractInfoMapper.deleteCtjContractInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同管理信息
     * 
     * @param id 合同管理主键
     * @return 结果
     */
    @Override
    public int deleteCtjContractInfoById(String id)
    {
        return ctjContractInfoMapper.deleteCtjContractInfoById(id);
    }
}
