package com.ruoyi.commondata.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.commondata.domain.SystemOrganization;

/**
 * 生产机构Service接口
 * 
 * @author lyf
 * @date 2024-10-09
 */
public interface ISystemOrganizationService 
{
    /**
     * 查询生产机构
     * 
     * @param id 生产机构主键
     * @return 生产机构
     */
    public SystemOrganization selectSystemOrganizationById(String id);

    /**
     * 查询生产机构列表
     * 
     * @param systemOrganization 生产机构
     * @return 生产机构集合
     */
    public List<SystemOrganization> selectSystemOrganizationList(SystemOrganization systemOrganization);


    /**
     * 新增生产机构
     * 
     * @param systemOrganization 生产机构
     * @return 结果
     */
    public AjaxResult insertSystemOrganization(SystemOrganization systemOrganization);

    /**
     * 修改生产机构
     * 
     * @param systemOrganization 生产机构
     * @return 结果
     */
    public int updateSystemOrganization(SystemOrganization systemOrganization);

    /**
     * 批量删除生产机构
     * 
     * @param ids 需要删除的生产机构主键集合
     * @return 结果
     */
    public int deleteSystemOrganizationByIds(String[] ids);

    /**
     * 删除生产机构信息
     * 
     * @param id 生产机构主键
     * @return 结果
     */
    public int deleteSystemOrganizationById(String id);
}
