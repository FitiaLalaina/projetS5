package com.culture.API.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culture.API.Models.MongodbEntity.FieldLocalisation;

public interface FieldLocalisationRepository extends MongoRepository<FieldLocalisation, String>{

        List<FieldLocalisation> findAll();
        FieldLocalisation findByHashcode(String hashcode);
        void deleteByHashcode(String hashcode);
}
