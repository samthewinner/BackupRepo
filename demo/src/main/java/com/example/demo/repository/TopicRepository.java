package com.example.demo.repository;

import com.example.demo.model.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TopicRepository  extends  MongoRepository<Topic,String> {
    Topic findByName(String name);
}
