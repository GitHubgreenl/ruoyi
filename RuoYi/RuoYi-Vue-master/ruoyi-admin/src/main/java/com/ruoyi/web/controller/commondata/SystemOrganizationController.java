package com.ruoyi.web.controller.commondata;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.commondata.domain.SystemOrganization;
import com.ruoyi.commondata.service.ISystemOrganizationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生产机构Controller
 * 
 * @author lyf
 * @date 2024-10-09
 */
@RestController
@RequestMapping("/commondata/organization")
public class SystemOrganizationController extends BaseController
{
    @Autowired
    private ISystemOrganizationService systemOrganizationService;

    /**
     * 查询生产机构列表
     */
    @PreAuthorize("@ss.hasPermi('commondata:organization:list')")
    @GetMapping("/list")
    public TableDataInfo list(SystemOrganization systemOrganization)
    {
        startPage();
        List<SystemOrganization> list = systemOrganizationService.selectSystemOrganizationList(systemOrganization);
        return getDataTable(list);
    }

    /**
     * 导出生产机构列表
     */
    @PreAuthorize("@ss.hasPermi('commondata:organization:export')")
    @Log(title = "生产机构", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SystemOrganization systemOrganization)
    {
        List<SystemOrganization> list = systemOrganizationService.selectSystemOrganizationList(systemOrganization);
        ExcelUtil<SystemOrganization> util = new ExcelUtil<SystemOrganization>(SystemOrganization.class);
        util.exportExcel(response, list, "生产机构数据");
    }

    /**
     * 获取生产机构详细信息
     */
    @PreAuthorize("@ss.hasPermi('commondata:organization:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(systemOrganizationService.selectSystemOrganizationById(id));
    }

    /**
     * 新增生产机构
     */
    @PreAuthorize("@ss.hasPermi('commondata:organization:add')")
    @Log(title = "生产机构", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SystemOrganization systemOrganization)
    {
        return systemOrganizationService.insertSystemOrganization(systemOrganization);
    }

    /**
     * 修改生产机构
     */
    @PreAuthorize("@ss.hasPermi('commondata:organization:edit')")
    @Log(title = "生产机构", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SystemOrganization systemOrganization)
    {
        return toAjax(systemOrganizationService.updateSystemOrganization(systemOrganization));
    }

    /**
     * 删除生产机构
     */
    @PreAuthorize("@ss.hasPermi('commondata:organization:remove')")
    @Log(title = "生产机构", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(systemOrganizationService.deleteSystemOrganizationByIds(ids));
    }
}
