package com.culture.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.AvgYieldPerCulturePerPlotView;
import com.culture.API.Repository.AvgYieldPerCulturePerPlotViewRepository;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("/api")
public class AvgYieldPerCulturePerPlotViewController {

    private final AvgYieldPerCulturePerPlotViewRepository repository;

    @Autowired
    public AvgYieldPerCulturePerPlotViewController(AvgYieldPerCulturePerPlotViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/avg-yield")
    public ResponseEntity<List<AvgYieldPerCulturePerPlotView>> getAllAvgYields() {
        try {
            List<AvgYieldPerCulturePerPlotView> avgYields = repository.findAll();
            System.out.println("avg yield:  "+avgYields.size());
            return new ResponseEntity<>(avgYields, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
