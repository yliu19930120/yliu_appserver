package com.yliu.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yliu.bean.Msg;

public interface MsgService {

	void save(Msg msg);
	
	Page<Msg> findByReceiverPhoneAndMsgDateGreaterThanEqual(
            String receiverPhone, Date from, Date to, Pageable pageable);
}
