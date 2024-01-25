package com.culture.API.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culture.API.Models.MongodbEntity.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String>{

        List<Notification> findAll();
        Notification findByHashcode(String id);
        void deleteByHashcode(String hashcode);
}
