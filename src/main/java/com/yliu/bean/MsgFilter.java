package com.yliu.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class MsgFilter {

	@ApiModelProperty("电话")
	private String receiverPhone;
	@ApiModelProperty("起始时间")
	private Date from;
	@ApiModelProperty("结束时间")
	private Date to;
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	
	
}
