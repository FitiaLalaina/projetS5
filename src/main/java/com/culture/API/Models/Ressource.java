package com.culture.API.Models;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.culture.API.Repository.*;
import java.util.List;

@Entity
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRessource;

    @Basic
    private String name;

    @Basic
    private double pricePerUnit;


    public Ressource() {

    }

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }


    public Ressource(int idRessource, String name, double pricePerUnit) {
        this.idRessource = idRessource;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }


    public static Ressource saveRessource(Ressource ressource, RessourceRepository rr) throws Exception{
        Ressource rs = rr.save(ressource);

        return rs;
    }

    public static List<Ressource> findAll(RessourceRepository rr) throws Exception{
        List<Ressource> r = rr.findAll();

        return r;
    }


}
