package com.yliu.service;

import java.util.Date;
import java.util.List;

import com.yliu.bean.Msg;

public interface MsgService {

	void save(Msg msg);
	
	List<Msg> findByReceiverPhoneAndMsgDateGreaterThanEqual(
			String receiverPhone,Date from);
}
