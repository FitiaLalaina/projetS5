package com.culture.API.Models.MongodbEntity;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Basic;

import com.culture.API.Models.DTO.OwnerDTO;
import com.culture.API.Repository.*;


@Document(collection="PendingField")
public class PendingField {
    
    private OwnerDTO owner;

    @Basic
    private String hashcode;

    @Basic
    private String description;
    
    @Basic
    private String location;

    @Basic
    private double area;

    @Basic
    private int groundType;

    @Basic
    private int plotNumber;


    public PendingField(){

    }

    public PendingField(OwnerDTO owner, String hashcode, String description, String location, double area,
            int groundType, int plotNumber) {
        this.owner = owner;
        this.hashcode = hashcode;
        this.description = description;
        this.location = location;
        this.area = area;
        this.groundType = groundType;
        this.plotNumber = plotNumber;
    }

    public PendingField(OwnerDTO owner, String hashcode, String description, String location, double area){
        this.owner = owner;
        this.hashcode = hashcode;
        this.description = description;
        this.location = location;
        this.area = area;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    public int getGroundType() {
        return groundType;
    }

    public void setGroundType(int groundType) {
        this.groundType = groundType;
    }

    public int getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(int plotNumber) {
        this.plotNumber = plotNumber;
    }

    public static List<PendingField> findAll(PendingFieldRepository repository) throws SQLException {
        List<PendingField> listPending = repository.findAll();
        return listPending;
    }

    public static PendingField save(PendingField pending, PendingFieldRepository repository) throws SQLException {
        PendingField n = repository.save(pending);
        return n;
    }

    public static PendingField findByHashcode(String hashcode, PendingFieldRepository repository)
    {
        return repository.findByHashcode(hashcode);
    }

}