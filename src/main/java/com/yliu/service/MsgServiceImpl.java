package com.yliu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Msg> findByReceiverPhoneAndMsgDateGreaterThanEqual(String receiverPhone,
			Date from) {
		return msgRepository.findByReceiverPhoneAndMsgDateGreaterThanEqual(receiverPhone, from);
	}

}
