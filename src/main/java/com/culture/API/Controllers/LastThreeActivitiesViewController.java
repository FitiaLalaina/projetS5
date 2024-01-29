package com.culture.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.LastThreeActivitiesView;
import com.culture.API.Repository.LastThreeActivitiesViewRepository;

@RestController
@RequestMapping("/api")
public class LastThreeActivitiesViewController {

    private final LastThreeActivitiesViewRepository repository;

    @Autowired
    public LastThreeActivitiesViewController(LastThreeActivitiesViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/last-three-activities/plot/{plotId}")
    public ResponseEntity<List<LastThreeActivitiesView>> getActivitiesByPlotId(@PathVariable int plotId) {
        try {
            List<LastThreeActivitiesView> activities = repository.findByidPlot(plotId);
            System.out.println("all.size  "+activities.size());
            return new ResponseEntity<>(activities, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/three/{plotId}")
    public ResponseEntity<List<LastThreeActivitiesView>> getLastThreeActivitiesByPlotId(@PathVariable int plotId) {
        try {
            List<LastThreeActivitiesView> activities = repository.findTop3ByIdPlotOrderByDateSimulationDesc(plotId);
            System.out.println("three.size  "+activities.size());
            return new ResponseEntity<>(activities, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


