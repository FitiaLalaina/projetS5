package com.culture.API.Controllers;
import com.culture.API.Models.Owner;
import com.culture.API.Models.Wallet;
import com.culture.API.Repository.OwnerRepository;
import com.culture.API.Repository.WalletRepository;
import com.culture.API.Utils.HashGenerator;

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

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})

public class RegisterController {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private WalletRepository walletRepository;

    @PostMapping("/register")
    public ResponseEntity<Owner> insertOwner(@RequestBody Owner o) {
        try {
            String accountNumber = HashGenerator.generateCode();
            Wallet wallet = new Wallet(accountNumber, 0, o);
            
            Owner ow = Owner.saveOwner(o, ownerRepository);
            Wallet wa = Wallet.saveWallet(wallet, walletRepository);
            return new ResponseEntity<>(o, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
