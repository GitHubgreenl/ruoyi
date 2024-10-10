package com.ruoyi.commondata.mapper;

import java.util.List;
import com.ruoyi.commondata.domain.SystemOrganization;

/**
 * 生产机构Mapper接口
 * 
 * @author lyf
 * @date 2024-10-09
 */
public interface SystemOrganizationMapper 
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
     * 查询生成机构层次码是否存在
     *
     * @param systemOrganization 生产机构
     * @return 生产机构集合
     */
    public List<SystemOrganization> selectLevelCode(SystemOrganization systemOrganization);
    /**
     * 查询生成机构层次码是否存在
     *
     * @param systemOrganization 生产机构
     * @return 生产机构集合
     */
    public List<SystemOrganization> selectLevelCodeToLevel(SystemOrganization systemOrganization);



    /**
     * 新增生产机构
     * 
     * @param systemOrganization 生产机构
     * @return 结果
     */
    public int insertSystemOrganization(SystemOrganization systemOrganization);

    /**
     * 修改生产机构
     * 
     * @param systemOrganization 生产机构
     * @return 结果
     */
    public int updateSystemOrganization(SystemOrganization systemOrganization);

    /**
     * 删除生产机构
     * 
     * @param id 生产机构主键
     * @return 结果
     */
    public int deleteSystemOrganizationById(String id);

    /**
     * 批量删除生产机构
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSystemOrganizationByIds(String[] ids);
}
