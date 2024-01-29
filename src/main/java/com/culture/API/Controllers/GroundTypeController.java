package com.culture.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.GroundType;
import com.culture.API.Repository.*;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("/api")
public class GroundTypeController {
    @Autowired
    GroundTypeRepository groundTypeRepository;

    @PostMapping("/groundtype")
    public ResponseEntity<GroundType> saveGroundType(@RequestBody GroundType groundType) {
        try {
            GroundType groundType2 = GroundType.saveGroundType(groundType, groundTypeRepository);
            return new ResponseEntity<>(groundType2, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

    @GetMapping("/groundtypes")
    public ResponseEntity<List<GroundType>> listGroundType() {
        try {
            List<GroundType> groundType = GroundType.listGroundType(groundTypeRepository);
            return new ResponseEntity<>(groundType, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}
