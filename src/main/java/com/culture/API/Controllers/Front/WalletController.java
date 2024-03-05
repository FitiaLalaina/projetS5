package com.culture.API.Controllers.Front;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.DepositRequest;
import com.culture.API.Models.Wallet;
import com.culture.API.Models.WalletTransaction;
import com.culture.API.Repository.OwnerRepository;
import com.culture.API.Repository.WalletRepository;
import com.culture.API.Repository.WalletTransactionRepository;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
public class WalletController {

    @Autowired
    private WalletTransactionRepository wtr;
    @Autowired
    private WalletRepository wr;

    @Autowired
    private OwnerRepository or;


    @PostMapping("/wallet/deposit")
    @Transactional(rollbackOn = Exception.class)
	public ResponseEntity<Object> createDeposit(@RequestBody DepositRequest depositRequest) {
        Wallet wallet = or.findByidOwner(depositRequest.getIdOwner()).getWallet();
        System.out.println(wallet.getIdWallet() + "fsdfsdklfjslddslfdsjfsdlks");
        WalletTransaction wt = new WalletTransaction();
        wt.setAmount(depositRequest.getAmount());
        wt.setType(0);
        wt.setWallet(wallet);

        if(depositRequest.getAmount() < 0)
        {
		    return new ResponseEntity<>("Negative Amount", HttpStatus.UNAUTHORIZED);
        }else{
             try {
                WalletTransaction walletTransaction = wallet.createTransaction(wtr, wr, depositRequest.getAmount(),1);
                return new ResponseEntity<>(walletTransaction, HttpStatus.OK);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
	}

    @GetMapping("/wallet") 
    public ResponseEntity<List<Wallet>> getAllWallet(){
        try{
            List<Wallet> w = Wallet.findAllWallet(wr);
            return new ResponseEntity<>(w, HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/wallets")
    public ResponseEntity<Wallet> insertWallet(@RequestBody Wallet w) {
        try{
            Wallet wt = Wallet.saveWallet(w, wr);
            return new ResponseEntity<>(wt,HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
    
}
