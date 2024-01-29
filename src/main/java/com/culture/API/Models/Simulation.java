package com.culture.API.Models;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Simulation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSimulation;

    @ManyToOne
    @JoinColumn(name="idPlot")
    private Plot plot;

    @Basic
    private int idCulture;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable=false)
    private Timestamp dateSimulation;

    public int getIdSimulation() {
        return idSimulation;
    }

    public void setIdSimulation(int idSimulation) {
        this.idSimulation = idSimulation;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public int getIdCulture() {
        return idCulture;
    }

    public void setIdCulture(int idCulture) {
        this.idCulture = idCulture;
    }

    public Timestamp getDateSimulation() {
        return dateSimulation;
    }

    public void setDateSimulation(Timestamp dateSimulation) {
        this.dateSimulation = dateSimulation;
    }

    public Simulation(int idSimulation, Plot plot, int idCulture, Timestamp dateSimulation) {
        this.idSimulation = idSimulation;
        this.plot = plot;
        this.idCulture = idCulture;
        this.dateSimulation = dateSimulation;
    }

    public Simulation()
    {
        
    }
    
}
