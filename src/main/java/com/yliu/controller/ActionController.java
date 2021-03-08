package com.yliu.controller;

import com.yliu.bean.PageResult;
import com.yliu.bean.Result;
import com.yliu.constant.BaseConst;
import com.yliu.service.TrainingActionService;
import com.yliu.utils.IdentityUtils;
import com.yliu.utils.TokenUtils;
import com.yliu.vo.ActionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Api(tags = "训练动作")
@RestController
@ResponseBody
@RequestMapping("/action")
public class ActionController {

    private final static Logger log = LoggerFactory.getLogger(ActionController.class);
    @Autowired
    private TrainingActionService trainingActionService;

    @ApiOperation(value = "保存动作")
    @PostMapping("/save")
    public Result save(@Valid @RequestBody ActionVo actionVo){
        trainingActionService.save(actionVo);
        return Result.ok();
    }

    @ApiOperation(value = "查询动作")
    @GetMapping("/action")
    public Result<List<ActionVo>> actionList(@RequestParam String userId,@RequestParam LocalDate traningDate){
        if(userId==null){
            return Result.failue("用户id为空");
        }
        ActionVo actionVo = new ActionVo();
        actionVo.setUserId(userId);
        actionVo.setTraningDate(traningDate);
        List<ActionVo> all = trainingActionService.findAll(actionVo);
        return Result.ok(all);
    }

    @ApiOperation(value = "查询训练日期")
    @GetMapping("/dates")
    public Result<List<LocalDate>> actionList(@RequestParam String userId,@RequestParam LocalDate from,@RequestParam LocalDate to){
        if(userId==null){
            return Result.failue("用户id为空");
        }
        List<LocalDate> dates = trainingActionService.distinctDates(userId,from,to);
        return Result.ok(dates);
    }

    @ApiOperation(value = "删除动作")
    @GetMapping("/delete")
    public Result deleteAction(@RequestParam String userId,@RequestParam String... actionIds){
        trainingActionService.deleteByIds(userId,actionIds);
        return Result.ok();
    }

    @ApiOperation(value = "更新动作")
    @PostMapping("/update")
    public Result update(@Valid @RequestBody ActionVo actionVo){
        trainingActionService.update(actionVo);
        return Result.ok();
    }


    @ApiOperation(value = "查询动作,分页")
    @GetMapping("/page")
    public PageResult<ActionVo> actionVoPageResult(@PageableDefault(sort = { "traningDate" }, direction = Sort.Direction.DESC) Pageable pageable,
                                                   @RequestParam String userId){
        ActionVo actionVo = new ActionVo();
        actionVo.setUserId(userId);
        PageResult<ActionVo> all = trainingActionService.findAll(actionVo,pageable);
        return all;
    }

    @ApiOperation(value = "批量导入")
    @PostMapping("/import")
    public Result importActions(@RequestParam("file")MultipartFile file,@RequestParam String userId){
        boolean empty = file.isEmpty();
        if(empty){
            return Result.failue("文件不能为空");
        }else {
            try {
                trainingActionService.importActions(file,userId);
            } catch (IOException e) {
                log.error("失败",e);
                return Result.failue("导入失败");
            }
        }
        return Result.ok();
    }

    @ApiOperation(value = "导出模板")
    @GetMapping(value = "/template")
    public void exportActions(HttpServletRequest request, HttpServletResponse response) throws IOException {
        trainingActionService.exporTemplate(response);
    }

}
