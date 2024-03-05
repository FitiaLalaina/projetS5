package com.culture.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culture.API.Models.Wallet;
import com.culture.API.Models.WalletTransaction;

@Repository
public interface WalletRepository  extends JpaRepository<Wallet , Integer> {

    Wallet findByIdWallet(int idWallet);
    
} 