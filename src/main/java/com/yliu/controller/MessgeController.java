package com.yliu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yliu.bean.Msg;
import com.yliu.bean.MsgFilter;
import com.yliu.bean.Result;
import com.yliu.service.MsgService;

@RestController
@ResponseBody
@RequestMapping("/msg")
public class MessgeController {
	
	private final static Logger log = LoggerFactory.getLogger(MessgeController.class);
	
	@Autowired
	private MsgService msgService;
	
	@PostMapping
	public Result getMsg(@RequestBody MsgFilter filter){
		log.info("查询信息");
		List<Msg> msgs = msgService.findByReceiverPhoneAndMsgDateGreaterThanEqual(
				filter.getReceiverPhone(), filter.getFrom());
		return Result.ok(msgs);
	}
	
	@PostMapping("/push")
	public Result pushMsg(@RequestBody Msg msg){
		log.info("推送消息");
		msgService.save(msg);
		return Result.ok();
	}

}
