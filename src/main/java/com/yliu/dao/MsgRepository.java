package com.yliu.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yliu.bean.Msg;

public interface MsgRepository extends MongoRepository<Msg, String>{

	public List<Msg> findByReceiverPhoneAndMsgDateGreaterThanEqual(
			String receiverPhone,Date from);
}
