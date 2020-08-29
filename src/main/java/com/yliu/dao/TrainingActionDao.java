package com.yliu.dao;

import com.yliu.bean.TrainingAction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainingActionDao extends MongoRepository<TrainingAction,String> {

}
