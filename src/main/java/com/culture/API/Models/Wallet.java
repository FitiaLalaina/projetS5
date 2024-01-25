package com.culture.API.Models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Wallet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idWallet;
    
    @Basic
    private String number;
    
    @Basic
    private double balance;
    
    @OneToOne
    @JoinColumn(name = "idOwner")
    private Owner owner;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.EAGER)
    private List<WalletTransaction> walletTransactions;

    
    public Wallet() {
    }

    public Wallet(int idWallet, String number, double balance, Owner owner,
            List<WalletTransaction> walletTransactions) {
        this.idWallet = idWallet;
        this.number = number;
        this.balance = balance;
        this.owner = owner;
        this.walletTransactions = walletTransactions;
    }


    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setUser(Owner owner) {
        this.owner = owner;
    }

}
