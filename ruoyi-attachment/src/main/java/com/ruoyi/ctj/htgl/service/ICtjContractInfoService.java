package com.ruoyi.ctj.htgl.service;

import com.ruoyi.ctj.htgl.domain.CtjContractInfo;

import java.util.List;

/**
 * 合同管理Service接口
 * 
 * @author philorun
 * @date 2023-05-31
 */
public interface ICtjContractInfoService {
    /**
     * 查询合同管理
     * 
     * @param id 合同管理主键
     * @return 合同管理
     */
    CtjContractInfo selectCtjContractInfoById(String id);

    /**
     * 查询合同管理列表
     * 
     * @param ctjContractInfo 合同管理
     * @return 合同管理集合
     */
    List<CtjContractInfo> selectCtjContractInfoList(CtjContractInfo ctjContractInfo);

    /**
     * 新增合同管理
     * 
     * @param ctjContractInfo 合同管理
     * @return 结果
     */
    int insertCtjContractInfo(CtjContractInfo ctjContractInfo);

    /**
     * 修改合同管理
     * 
     * @param ctjContractInfo 合同管理
     * @return 结果
     */
    int updateCtjContractInfo(CtjContractInfo ctjContractInfo);

    /**
     * 批量删除合同管理
     * 
     * @param ids 需要删除的合同管理主键集合
     * @return 结果
     */
    int deleteCtjContractInfoByIds(String ids);

    /**
     * 删除合同管理信息
     * 
     * @param id 合同管理主键
     * @return 结果
     */
    int deleteCtjContractInfoById(String id);
}
