package com.foelep.system.survey;

import com.foelep.common.core.utils.poi.ExcelUtil;
import com.foelep.common.core.web.controller.BaseController;
import com.foelep.common.core.web.domain.AjaxResult;
import com.foelep.common.core.web.page.TableDataInfo;
import com.foelep.common.log.annotation.Log;
import com.foelep.common.log.enums.BusinessType;
import com.foelep.common.security.annotation.RequiresPermissions;
import com.foelep.system.domain.survey.SurveyOptions;
import com.foelep.system.service.survey.ISurveyOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 题目选项Controller
 *
 * @author 2y
 * @date 2021-03-21
 */
@RestController
@RequestMapping("/survey/options")
public class SurveyOptionsController extends BaseController {
    @Autowired
    private ISurveyOptionsService surveyOptionsService;

    /**
     * 查询题目选项列表
     */
    @RequiresPermissions("survey:options:list")
    @GetMapping("/list")
    public TableDataInfo list(SurveyOptions surveyOptions) {
        startPage();
        List<SurveyOptions> list = surveyOptionsService.selectSurveyOptionsList(surveyOptions);
        return getDataTable(list);
    }

    /**
     * 导出题目选项列表
     */
    @RequiresPermissions("survey:options:export")
    @Log(title = "题目选项", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public void export(HttpServletResponse response, SurveyOptions surveyOptions) {
        List<SurveyOptions> list = surveyOptionsService.selectSurveyOptionsList(surveyOptions);
        ExcelUtil<SurveyOptions> util = new ExcelUtil<SurveyOptions>(SurveyOptions.class);
        util.exportExcel(response, list, "options");
    }

    /**
     * 获取题目选项详细信息
     */
    @RequiresPermissions("survey:options:query")
    @GetMapping(value = "/{optionId}")
    public AjaxResult getInfo(@PathVariable("optionId") Long optionId) {
        return AjaxResult.success(surveyOptionsService.selectSurveyOptionsById(optionId));
    }

    /**
     * 新增题目选项
     */
    @RequiresPermissions("survey:options:add")
    @Log(title = "题目选项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SurveyOptions surveyOptions) {
        return toAjax(surveyOptionsService.insertSurveyOptions(surveyOptions));
    }

    /**
     * 修改题目选项
     */
    @RequiresPermissions("survey:options:edit")
    @Log(title = "题目选项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SurveyOptions surveyOptions) {
        return toAjax(surveyOptionsService.updateSurveyOptions(surveyOptions));
    }

    /**
     * 删除题目选项
     */
    @RequiresPermissions("survey:options:remove")
    @Log(title = "题目选项", businessType = BusinessType.DELETE)
    @DeleteMapping("/{optionIds}")
    public AjaxResult remove(@PathVariable Long[] optionIds) {
        return toAjax(surveyOptionsService.deleteSurveyOptionsByIds(optionIds));
    }
}
