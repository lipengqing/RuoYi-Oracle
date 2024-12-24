package com.ruoyi.ctj.htgl.mapper;

import com.ruoyi.ctj.htgl.domain.CtjContractInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 合同管理Mapper接口
 * 
 * @author philorun
 * @date 2023-05-31
 */
@Repository
public interface CtjContractInfoMapper {
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
     * 删除合同管理
     * 
     * @param id 合同管理主键
     * @return 结果
     */
    int deleteCtjContractInfoById(String id);

    /**
     * 批量删除合同管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteCtjContractInfoByIds(String[] ids);
}
