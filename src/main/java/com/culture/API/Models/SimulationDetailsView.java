package com.culture.API.Models;

public class SimulationDetailsView {
    private int idSimulation;
    private int idDetails;
    private String actionName;
    private int quantity;
    private double price;
    public int getIdSimulation() {
        return idSimulation;
    }
    public void setIdSimulation(int idSimulation) {
        this.idSimulation = idSimulation;
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
    public SimulationDetailsView(int idSimulation, int idDetails, String actionName, int quantity, double price) {
        this.idSimulation = idSimulation;
        this.idDetails = idDetails;
        this.actionName = actionName;
        this.quantity = quantity;
        this.price = price;
    }
    public SimulationDetailsView() {
    }

}

