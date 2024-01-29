package com.culture.API.Models;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LastThreeActivitiesView {
    @Id
    private int idSimulation;
    private int idPlot;
    private int idDetails;
    private String actionName;
    private int quantity;
    private double price;
    private Timestamp dateSimulation;
    
    public int getIdSimulation() {
        return idSimulation;
    }
    public void setIdSimulation(int idSimulation) {
        this.idSimulation = idSimulation;
    }
    public int getIdPlot() {
        return idPlot;
    }
    public void setIdPlot(int idPlot) {
        this.idPlot = idPlot;
    }
    public int getIdDetails() {
        return idDetails;
    }
    public void setIdDetails(int idDetails) {
        this.idDetails = idDetails;
    }
    public String getActionName() {
        return actionName;
    }
    public void setActionName(String actionName) {
        this.actionName = actionName;
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
    public Timestamp getDateSimulation() {
        return dateSimulation;
    }
    public void setDateSimulation(Timestamp dateSimulation) {
        this.dateSimulation = dateSimulation;
    }
    public LastThreeActivitiesView(int idSimulation, int idPlot, int idDetails, String actionName, int quantity,
            double price, Timestamp dateSimulation) {
        this.idSimulation = idSimulation;
        this.idPlot = idPlot;
        this.idDetails = idDetails;
        this.actionName = actionName;
        this.quantity = quantity;
        this.price = price;
        this.dateSimulation = dateSimulation;
    }
    public LastThreeActivitiesView() {
    }

}

