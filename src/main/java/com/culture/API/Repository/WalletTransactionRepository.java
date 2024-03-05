package com.culture.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culture.API.Models.WalletTransaction;

@Repository
public interface WalletTransactionRepository  extends JpaRepository<WalletTransaction , Integer> {

    WalletTransaction save(WalletTransaction wt);

    
} 