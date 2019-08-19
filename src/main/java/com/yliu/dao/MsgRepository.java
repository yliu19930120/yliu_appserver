package com.yliu.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.yliu.bean.Msg;

public interface MsgRepository extends MongoRepository<Msg, String>{
	
	@Query(value="{'receiverPhone':?#{[0]},'msgDate':{'$gte':?#{[1]},'$lte':?#{[2]}}}",sort="{'msgDate':-1}")  
	Page<Msg> findByReceiverPhoneAndMsgDateRange(String receiverPhone, Date from, Date to, Pageable pageable);
}
