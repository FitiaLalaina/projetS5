package com.culture.API.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.Plot;
import com.culture.API.Repository.PlotRepository;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("/api")
public class PlotController {
    @Autowired

    PlotRepository plotRepository;

    @PostMapping("/plot")
    public ResponseEntity<Plot> savePlot(@RequestBody Plot plot) {
        try {
            Plot plot2 = Plot.savePlot(plot, plotRepository);
            return new ResponseEntity<>(plot2, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}
