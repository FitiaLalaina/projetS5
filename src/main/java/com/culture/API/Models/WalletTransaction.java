package com.culture.API.Models;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class WalletTransaction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaction;
    
    @ManyToOne
    @JoinColumn(name = "idWallet")
    private Wallet wallet;

    @Basic
    private int type;
    
    @Basic
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dateTransaction;

    public WalletTransaction() {
    }

    public WalletTransaction(int idTransaction, Wallet wallet, int type, double amount, Timestamp dateTransaction) {
        this.idTransaction = idTransaction;
        this.wallet = wallet;
        this.type = type;
        this.amount = amount;
        this.dateTransaction = dateTransaction;
    }


    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Timestamp dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

}
