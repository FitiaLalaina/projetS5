package com.culture.API.Controllers.Front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.Simulation;
import com.culture.API.Models.Request.AddSimulationRequest;
import com.culture.API.Repository.ActionRepository;
import com.culture.API.Repository.FieldRepository;
import com.culture.API.Repository.SimulationDetailsRepository;
import com.culture.API.Repository.SimulationRepository;
import com.culture.API.Repository.YieldRepository;

import com.culture.API.Repository.WalletRepository;
import com.culture.API.Repository.WalletTransactionRepository;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("/api")
public class SimulationController {
    @Autowired
    YieldRepository yr; 
    @Autowired
    SimulationRepository sr;
    @Autowired
    SimulationDetailsRepository sdr;
    @Autowired
    ActionRepository ar;
    @Autowired
    WalletRepository wr;
    @Autowired
    WalletTransactionRepository wtr;
    @Autowired
    FieldRepository fr;
    
    @PostMapping("/insertSimulation")
    public ResponseEntity<Simulation> insertSimulation(
        @RequestBody AddSimulationRequest asr) {
        
        try {
            Simulation simulation = new Simulation();
            simulation = simulation.insertSimulation(fr, wr, wtr, yr, sr, sdr, ar, asr.idSimulation, asr.plot, asr.culture, asr.ressource, asr.quantity);

            return new ResponseEntity<>(simulation, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
