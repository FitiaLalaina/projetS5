package com.culture.API.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culture.API.Models.MongodbEntity.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
    
        List<Message> findAll();
        Message save(Message message);
    
}
