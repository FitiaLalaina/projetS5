package com.culture.API.Models.MongodbEntity;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.culture.API.Repository.FieldPicturesRepository;

import jakarta.persistence.Basic;


@Document(collection="FieldPictures")
public class FieldPictures {
    
    @Basic
    private String hashcode;

    @Basic
    private String picBase64;

    public FieldPictures(){

    }

    public FieldPictures(String hashcode, String picBase64) {
        this.hashcode = hashcode;
        this.picBase64 = picBase64;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public String getPicBase64() {
        return picBase64;
    }

    public void setPicBase64(String picBase64) {
        this.picBase64 = picBase64;
    }

    public static List<FieldPictures> findAll(FieldPicturesRepository repository) throws SQLException {
        List<FieldPictures> listPending = repository.findAll();
        return listPending;
    }

    public static FieldPictures save(FieldPictures pending, FieldPicturesRepository repository) throws SQLException {
        FieldPictures n = repository.save(pending);
        return n;
    }

    public static FieldPictures findByHashcode(String hashcode, FieldPicturesRepository repository)
    {
        return repository.findByhashcode(hashcode);
    }

}