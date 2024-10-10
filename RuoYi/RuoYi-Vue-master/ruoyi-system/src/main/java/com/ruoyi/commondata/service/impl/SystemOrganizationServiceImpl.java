package com.ruoyi.commondata.service.impl;

import java.util.Collections;
import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.commondata.mapper.SystemOrganizationMapper;
import com.ruoyi.commondata.domain.SystemOrganization;
import com.ruoyi.commondata.service.ISystemOrganizationService;

import static com.ruoyi.common.core.domain.AjaxResult.error;
import static com.ruoyi.common.core.domain.AjaxResult.success;


/**
 * 生产机构Service业务层处理
 * 
 * @author lyf
 * @date 2024-10-09
 */
@Service
public class SystemOrganizationServiceImpl implements ISystemOrganizationService 
{
    @Autowired
    private SystemOrganizationMapper systemOrganizationMapper;

    /**
     * 查询生产机构
     * 
     * @param id 生产机构主键
     * @return 生产机构
     */
    @Override
    public SystemOrganization selectSystemOrganizationById(String id)
    {
        return systemOrganizationMapper.selectSystemOrganizationById(id);
    }

    /**
     * 查询生产机构列表
     * 
     * @param systemOrganization 生产机构
     * @return 生产机构
     */
    @Override
    public List<SystemOrganization> selectSystemOrganizationList(SystemOrganization systemOrganization)
    {
        return systemOrganizationMapper.selectSystemOrganizationList(systemOrganization);
    }



    /**
     * 新增生产机构
     * 
     * @param systemOrganization 生产机构
     * @return 结果
     */
    @Override
    public AjaxResult insertSystemOrganization(SystemOrganization systemOrganization)
    {
        systemOrganization.setId(IdUtils.randomUUID());
        String levelCode = systemOrganization.getLevelCode();
        int length = StringUtils.length(levelCode);
        if(length==3){
            systemOrganization.setLevelType("Factory");
            //如果数据库输入的生产机构层次码
            for (SystemOrganization organization : systemOrganizationMapper.selectLevelCode(systemOrganization)) {
                //判断输入的生产机构码是否存在相同的
                //若不同则允许输入
                if(StringUtils.substring(organization.getLevelCode(),0,3).equals(systemOrganization.getLevelCode())){
                    return error("新增生产机构'" + systemOrganization.getName() + "'失败，生产层次机构码已存在");
                }
            }
            systemOrganization.setDatabaseID(IdUtils.randomUUID());

        }else if(length==5){
            systemOrganization.setLevelType("ProductionLine");
            //若不存在父机构
            SystemOrganization temp=new SystemOrganization();
            temp.setLevelCode(StringUtils.substring(systemOrganization.getLevelCode(),0,3));
           if(StringUtils.isNull(systemOrganizationMapper.selectLevelCode(temp))){
               return error("新增生产机构'" + systemOrganization.getName() + "'失败，该生产机构的父机构不存在");
           }else
           //父机构存在,若存在相同的生产层次机构码
           if(StringUtils.isNull(systemOrganizationMapper.selectLevelCode(systemOrganization))){
                return error("新增生产机构'" + systemOrganization.getName() + "'失败，生产层次机构码已存在");
        }else{
               //判断本层是否存在其他生产线
               List<SystemOrganization> systemOrganizations = systemOrganizationMapper.selectLevelCodeToLevel(temp);
               //若之前该机构存在其他的生产线
               if(systemOrganizations.size()>1){
                   //设置为本层其他元素的值
                   for (SystemOrganization organization : systemOrganizations) {
                       if(organization.getLevelCode().length()>3){
                           systemOrganization.setDatabaseID(organization.getDatabaseID());
                       }
                   }



               }
               else{
                   //设置为随机的值
                   systemOrganization.setDatabaseID(IdUtils.randomUUID());
               }
           }

        }

        systemOrganization.setCoefficientAltitude(1l);
        systemOrganization.setEnabled("1");
        systemOrganizationMapper.insertSystemOrganization(systemOrganization);
        return success("插入成功");
    }

    /**
     * 修改生产机构
     * 
     * @param systemOrganization 生产机构
     * @return 结果
     */
    @Override
    public int updateSystemOrganization(SystemOrganization systemOrganization)
    {
        return systemOrganizationMapper.updateSystemOrganization(systemOrganization);
    }

    /**
     * 批量删除生产机构
     * 
     * @param ids 需要删除的生产机构主键
     * @return 结果
     */
    @Override
    public int deleteSystemOrganizationByIds(String[] ids)
    {
        return systemOrganizationMapper.deleteSystemOrganizationByIds(ids);
    }

    /**
     * 删除生产机构信息
     * 
     * @param id 生产机构主键
     * @return 结果
     */
    @Override
    public int deleteSystemOrganizationById(String id)
    {
        return systemOrganizationMapper.deleteSystemOrganizationById(id);
    }
}
