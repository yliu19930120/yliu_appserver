package com.yliu.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yliu.bean.Msg;
import com.yliu.dao.MsgRepository;

@Service
public class MsgServiceImpl implements MsgService{

	@Autowired
	private MsgRepository msgRepository;
	
	@Override
	public void save(Msg msg) {
		msgRepository.save(msg);
	}

	@Override
	public Page<Msg> findByReceiverPhoneAndMsgDateGreaterThanEqual(String receiverPhone,
			Date from, Date to, Pageable pageable) {
	      return msgRepository.findByReceiverPhoneAndMsgDateRange(receiverPhone, from, to, pageable);
	}

}
