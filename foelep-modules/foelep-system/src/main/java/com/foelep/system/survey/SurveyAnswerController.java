package com.foelep.system.survey;

import com.foelep.common.core.utils.poi.ExcelUtil;
import com.foelep.common.core.web.controller.BaseController;
import com.foelep.common.core.web.domain.AjaxResult;
import com.foelep.common.core.web.page.TableDataInfo;
import com.foelep.common.log.annotation.Log;
import com.foelep.common.log.enums.BusinessType;
import com.foelep.common.security.annotation.RequiresPermissions;
import com.foelep.system.domain.survey.SurveyAnswer;
import com.foelep.system.domain.survey.dto.SurveyAnswerDto;
import com.foelep.system.service.survey.ISurveyAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 问卷填写Controller
 *
 * @author 2y
 * @date 2021-03-21
 */
@RestController
@RequestMapping("/survey/answer")
public class SurveyAnswerController extends BaseController {
    @Autowired
    private ISurveyAnswerService surveyAnswerService;

    /**
     * 查询问卷填写列表
     */
    @RequiresPermissions("survey:answer:list")
    @GetMapping("/list")
    public TableDataInfo list(SurveyAnswer surveyAnswer) {
        startPage();
        List<SurveyAnswer> list = surveyAnswerService.selectSurveyAnswerList(surveyAnswer);
        return getDataTable(list);
    }

    /**
     * 查询问卷填写列表
     */
    @RequiresPermissions("survey:answer:list")
    @GetMapping("/allList")
    public TableDataInfo allList(SurveyAnswerDto surveyAnswer) {
        startPage();
        List<SurveyAnswerDto> list = surveyAnswerService.selectAllList(surveyAnswer);
        return getDataTable(list);
    }

    /**
     * 导出问卷填写列表
     */
    @RequiresPermissions("survey:answer:export")
    @Log(title = "问卷填写", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public void export(HttpServletResponse response, SurveyAnswer surveyAnswer) {
        List<SurveyAnswer> list = surveyAnswerService.selectSurveyAnswerList(surveyAnswer);
        ExcelUtil<SurveyAnswer> util = new ExcelUtil<SurveyAnswer>(SurveyAnswer.class);
        util.exportExcel(response, list, "answer");
    }

    /**
     * 获取问卷填写详细信息
     */
    @RequiresPermissions("survey:answer:query")
    @GetMapping(value = "/{answerId}")
    public AjaxResult getInfo(@PathVariable("answerId") Long answerId) {
        return AjaxResult.success(surveyAnswerService.selectSurveyAnswerById(answerId));
    }

    /**
     * 根据用户编号调查问卷查询填写详情
     */
    @GetMapping(value = "/detail/{paperId}/{userId}")
    public AjaxResult getDetailInfo(@PathVariable("paperId") Long paperId, @PathVariable("userId") Long userId) {
        return AjaxResult.success(surveyAnswerService.searchAllByUserId(paperId, userId));
    }

    /**
     * 新增问卷填写
     */
    @RequiresPermissions("survey:answer:add")
    @Log(title = "问卷填写", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SurveyAnswer surveyAnswer) {
        return toAjax(surveyAnswerService.insertSurveyAnswer(surveyAnswer));
    }

    /**
     * 新增问卷填写
     */
    @Log(title = "问卷填写", businessType = BusinessType.INSERT)
    @PostMapping("/addBatch")
    public AjaxResult addBatch(@RequestBody List<SurveyAnswer> surveyAnswer) {
        return toAjax(surveyAnswerService.addBatch(surveyAnswer));
    }

    /**
     * 修改问卷填写
     */
    @RequiresPermissions("survey:answer:edit")
    @Log(title = "问卷填写", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SurveyAnswer surveyAnswer) {
        return toAjax(surveyAnswerService.updateSurveyAnswer(surveyAnswer));
    }

    /**
     * 删除问卷填写
     */
    @RequiresPermissions("survey:answer:remove")
    @Log(title = "问卷填写", businessType = BusinessType.DELETE)
    @DeleteMapping("/{answerIds}")
    public AjaxResult remove(@PathVariable Long[] answerIds) {
        return toAjax(surveyAnswerService.deleteSurveyAnswerByIds(answerIds));
    }
}
