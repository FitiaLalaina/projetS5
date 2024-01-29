package com.culture.API.Models;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Yield implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idYield;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idSimulation")
    private Simulation simulation;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dateYield;

    @Basic
    private int quantity;

    public int getIdYield() {
        return idYield;
    }

    public void setIdYield(int idYield) {
        this.idYield = idYield;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setIdSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public Timestamp getDateYield() {
        return dateYield;
    }

    public void setDateYield(Timestamp dateYield) {
        this.dateYield = dateYield;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Yield(int idYield, Simulation simulation, Timestamp dateYield, int quantity) {
        this.idYield = idYield;
        this.simulation = simulation;
        this.dateYield = dateYield;
        this.quantity = quantity;
    }

    public Yield() {

    } 

}
