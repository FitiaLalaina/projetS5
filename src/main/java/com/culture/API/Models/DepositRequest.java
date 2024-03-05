package com.culture.API.Models;

public class DepositRequest {

    private int idOwner;
    private double amount;

    public int getIdOwner() {
        return idOwner;
    }
    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public DepositRequest(int idOwner, double amount) {
        this.idOwner = idOwner;
        this.amount = amount;
    }

    

    
    
}
