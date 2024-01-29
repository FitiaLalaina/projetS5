package com.culture.API.Controllers;

import com.culture.API.Models.Owner;
import com.culture.API.Repository.OwnerRepository;
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
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;
    // private FieldRepository fieldRepository;

    @GetMapping("/owners") 
    public ResponseEntity<List<Owner>> getAllOwner(){
        try{
            List<Owner> o = Owner.findAllOwner(ownerRepository);
            return new ResponseEntity<>(o, HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Owner> login(@RequestBody Owner o) {
        try{
            Owner ow = o.login(ownerRepository);
            if(ow!=null){
                return new ResponseEntity<>(ow,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/owner")
    public ResponseEntity<Owner> insertOwner(@RequestBody Owner o) {
        try{
            Owner ow = Owner.saveOwner(o, ownerRepository);
            return new ResponseEntity<>(ow,HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
    
    // @GetMapping("/owners")
    // public ResponseEntity<List<Field>> getOwnersWithFields(){
    //     try{
    //         Owner f= ownerRepository.findByidOwner(1);
    //         List<Field> fi = fieldRepository.findByOwner(f);
    //         return new ResponseEntity<>(fi,HttpStatus.OK);
    //     }
    //     catch(Exception e){
    //         System.out.println(e.getMessage());
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
    
}
