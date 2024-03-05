package com.culture.API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.culture.API.Models.MongodbEntity.FieldPictures;

public interface FieldPicturesRepository extends MongoRepository<FieldPictures, String>{

        List<FieldPictures> findAll();
        FieldPictures findByhashcode(String hash);
        void deleteByHashcode(String hashcode);
}
