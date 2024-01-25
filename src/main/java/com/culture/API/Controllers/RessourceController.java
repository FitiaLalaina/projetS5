package com.culture.API.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import com.culture.API.Models.Ressource;
import com.culture.API.Repository.RessourceRepository;

@RestController
@RequestMapping("/api")
public class RessourceController {
    @Autowired

    RessourceRepository ressourceRepository;

    @PostMapping("/ressources")
	public ResponseEntity<Ressource> saveRessource(@RequestBody Ressource ressource) 
    {
        try { 
            Ressource ressources = Ressource.saveRessource(ressource, ressourceRepository);
            return new ResponseEntity<>(ressources, HttpStatus.OK);
        } catch( Exception e) {    
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
	}


    @GetMapping("/ressources")
	public ResponseEntity<List<Ressource>> findRessource() 
    {
        try {
            List<Ressource> ressources = Ressource.findAll(ressourceRepository);
            return new ResponseEntity<>(ressources, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
	}


}