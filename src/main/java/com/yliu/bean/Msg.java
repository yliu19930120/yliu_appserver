package com.yliu.bean;

import java.util.Date;

public class Msg extends Bean{
	
	/**
	 * 发送人的手机
	 */
	private String senderPhone;
	/**
	 * 发送人的名称
	 */
	private String senderName;
	/**
	 * 信息内容
	 */
	private String content;
	/**
	 * 短信的日期
	 */
	private Date msgDate;
	/**
	 * 接收者的手机
	 */
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
	public Date getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	
	
}
