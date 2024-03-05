package com.culture.API.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culture.API.Models.MongodbEntity.PendingField;

public interface PendingFieldRepository extends MongoRepository<PendingField, String>{

        List<PendingField> findAll();
        PendingField findByHashcode(String hashcode);
        void deleteByHashcode(String hashcode);
}
