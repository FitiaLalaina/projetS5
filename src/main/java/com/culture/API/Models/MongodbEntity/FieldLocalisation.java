package com.culture.API.Models.MongodbEntity;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.culture.API.Repository.FieldLocalisationRepository;

import jakarta.persistence.Basic;


@Document(collection="FieldLocalisation")
public class FieldLocalisation {
    
    @Basic
    private String hashcode;

    @Basic
    private double longitude;

    @Basic
    private double latitude;

    public FieldLocalisation(){

    }

    public FieldLocalisation(String hashcode, double longitude, double latitude){
        this.hashcode = hashcode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public static List<FieldLocalisation> findAll(FieldLocalisationRepository repository) throws SQLException {
        List<FieldLocalisation> listPending = repository.findAll();
        return listPending;
    }

    public static FieldLocalisation save(FieldLocalisation pending, FieldLocalisationRepository repository) throws SQLException {
        FieldLocalisation n = repository.save(pending);
        return n;
    }

    public static FieldLocalisation findByHashcode(String hashcode, FieldLocalisationRepository repository)
    {
        return repository.findByHashcode(hashcode);
    }

}