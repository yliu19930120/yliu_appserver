package com.yliu.controller;

import com.yliu.bean.PageResult;
import com.yliu.bean.Result;
import com.yliu.constant.BaseConst;
import com.yliu.service.TrainingActionService;
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
    public Result save(@Valid ActionVo actionVo,@RequestHeader(BaseConst.TOKEN_KEY) String token){
        String userId = TokenUtils.decodeToken(token);
        actionVo.setUserId(userId);
        trainingActionService.save(actionVo);
        return Result.ok();
    }

    @ApiOperation(value = "查询动作")
    @PostMapping("/action")
    public Result<List<ActionVo>> actionList(@RequestHeader(BaseConst.TOKEN_KEY) String token,@RequestParam LocalDate traningDate){
        ActionVo actionVo = new ActionVo();
        actionVo.setUserId(TokenUtils.decodeToken(token));
        actionVo.setTraningDate(traningDate);
        List<ActionVo> all = trainingActionService.findAll(actionVo);
        return Result.ok(all);
    }

    @ApiOperation(value = "查询动作,分页")
    @PostMapping("/page")
    public PageResult<ActionVo> actionVoPageResult(@PageableDefault(sort = { "traningDate" }, direction = Sort.Direction.DESC) Pageable pageable,
                                                   @RequestHeader(BaseConst.TOKEN_KEY) String token){
        ActionVo actionVo = new ActionVo();
        actionVo.setUserId(TokenUtils.decodeToken(token));
        PageResult<ActionVo> all = trainingActionService.findAll(actionVo,pageable);
        return all;
    }

    @ApiOperation(value = "批量导入")
    @PostMapping("/import")
    public Result importActions(@RequestParam("file")MultipartFile file,@RequestHeader(BaseConst.TOKEN_KEY) String token){
        String userId = TokenUtils.decodeToken(token);
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
