package com.yliu.controller;

import com.yliu.bean.PageResult;
import com.yliu.service.MsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yliu.bean.Msg;
import com.yliu.bean.MsgFilter;
import com.yliu.bean.Result;

@Api(tags = "消息推送")
@RestController
@ResponseBody
@RequestMapping("/msg")
public class MessgeController {
	
	private final static Logger log = LoggerFactory.getLogger(MessgeController.class);
	
	@Autowired
	private MsgService msgService;

	@ApiOperation(value = "查询信息")
	@PostMapping
	public PageResult<Msg> getMsg(@RequestBody(required = true) MsgFilter filter, Pageable pageable){
		log.info("查询信息");
		Page<Msg> msgs = msgService.findByReceiverPhoneAndMsgDateGreaterThanEqual(
				filter.getReceiverPhone(), filter.getFrom(),filter.getTo(),pageable);
		return PageResult.ok(msgs);
	}
	
	@PostMapping("/push")
	public Result pushMsg(@RequestBody(required = true) Msg msg){
		log.info("推送消息");
		msgService.save(msg);
		return Result.ok();
	}

}
