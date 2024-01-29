package com.culture.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.AvgYieldPerCulturePerPlotPerMonthView;
import com.culture.API.Repository.AvgYieldPerCulturePerPlotPerMonthViewRepository;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("/api")
public class AvgYieldPerCulturePerPlotPerMonthViewController {
    private final AvgYieldPerCulturePerPlotPerMonthViewRepository repository;

    @Autowired
    public AvgYieldPerCulturePerPlotPerMonthViewController(AvgYieldPerCulturePerPlotPerMonthViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/avg-per-month/plot/{plotId}/month/{month}")
    public ResponseEntity<List<AvgYieldPerCulturePerPlotPerMonthView>> getAvgYieldByPlotAndMonth(
            @PathVariable int plotId, @PathVariable int month) {
        try {
            List<AvgYieldPerCulturePerPlotPerMonthView> avgYields = repository.findByIdPlotAndMonth(plotId, month);
            return new ResponseEntity<>(avgYields, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/plot/{plotId}")
    // public ResponseEntity<List<AvgYieldPerCulturePerPlotPerMonthView>> getAvgYieldByPlot(
    //         @PathVariable int plotId) {
    //     try {
    //         List<AvgYieldPerCulturePerPlotPerMonthView> avgYields = repository.findByIdPlot(plotId);
    //         return new ResponseEntity<>(avgYields, HttpStatus.OK);
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
}


