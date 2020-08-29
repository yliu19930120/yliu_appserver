package com.yliu.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@ApiModel("消息")
public class Msg extends Bean{
	

	@ApiModelProperty("发送人的手机")
	private String senderPhone;

	@ApiModelProperty("发送人的名称")
	private String senderName;

	@ApiModelProperty("信息内容")
	private String content;

	@ApiModelProperty("短信的日期")
	private LocalDateTime msgDate;

	@ApiModelProperty("接收者的手机")
	private String receiverPhone;

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(LocalDateTime msgDate) {
		this.msgDate = msgDate;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
}
