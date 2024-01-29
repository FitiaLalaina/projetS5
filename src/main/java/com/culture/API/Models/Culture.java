package com.culture.API.Models;

import java.io.Serializable;
import java.util.List;

import com.culture.API.Repository.CultureRepository;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Culture implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCulture;

    @Basic
    private String name;///nom de culture

    @Basic
    private double seedQuantity; ///Quantite semence

    @Basic
    private double yieldQuantity; /// Quantite rendement maximum par m2

    @Basic
    private int unit; // 1 || 2  ///Unite

    @Basic
    private double seedPrice;/// prix semence

    @Basic
    private double yieldPrice;/// prix rendement

    @ManyToOne()
    @JoinColumn(name="idGroundType")/// Type de sol
    private GroundType groundType;

    @ManyToOne()
    @JoinColumn(name="idCategory")
    private Category category;

    public Culture(){

    }

    public int getIdCulture() {
        return idCulture;
    }

    public void setIdCulture(int idCulture) {
        this.idCulture = idCulture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSeedQuantity() {
        return seedQuantity;
    }

    public void setSeedQuantity(double seedQuantity) {
        this.seedQuantity = seedQuantity;
    }

    public double getYieldQuantity() {
        return yieldQuantity;
    }

    public void setYieldQuantity(double yieldQuantity) {
        this.yieldQuantity = yieldQuantity;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getSeedPrice() {
        return seedPrice;
    }

    public void setSeedPrice(double seedPrice) {
        this.seedPrice = seedPrice;
    }

    public double getYieldPrice() {
        return yieldPrice;
    }

    public void setYieldPrice(double yieldPrice) {
        this.yieldPrice = yieldPrice;
    }

    public GroundType getGroundType() {
        return groundType;
    }

    public void setGroundType(GroundType groundType) {
        this.groundType = groundType;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public Culture(int idCulture, String name, double seedQuantity, double yieldQuantity, int unit, double seedPrice,
    double yieldPrice, GroundType groundType, Category category) {
        this.idCulture = idCulture;
        this.name = name;
        this.seedQuantity = seedQuantity;
        this.yieldQuantity = yieldQuantity;
        this.unit = unit;
        this.seedPrice = seedPrice;
        this.yieldPrice = yieldPrice;
        this.groundType = groundType;
        this.category = category;
        }

    
    public static Culture saveCulture(Culture culture, CultureRepository cr) throws Exception{

       Culture c =  cr.save(culture);
       return c;
    }

    public static List<Culture> findAll(CultureRepository cr) throws Exception
    {
        List<Culture> c = cr.findAll();
        return c;
    }

}
