package com.culture.API.Models;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class SimulationDetails implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetails;

    @OneToOne
    @JoinColumn(name = "idSimulation")
    private Simulation simulation;

    @ManyToOne
    @JoinColumn(name="idAction")
    private Action action;

    @Basic
    private int quantity;

    @Basic
    private double price;

    public int getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(int idDetails) {
        this.idDetails = idDetails;
    }
    
    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    } 

    public SimulationDetails(int idDetails, Simulation simulation, Action action, int quantity, double price) {
        this.idDetails = idDetails;
        this.simulation = simulation;
        this.action = action;
        this.quantity = quantity;
        this.price = price;
    }

    public SimulationDetails()
    {
        
    }
    
}
