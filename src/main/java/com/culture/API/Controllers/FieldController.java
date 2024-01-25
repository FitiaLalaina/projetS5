package com.culture.API.Controllers;

import com.culture.API.Models.Field;
import com.culture.API.Repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FieldController {
    
    @Autowired
    private FieldRepository fieldRepository;

    @GetMapping("/fields")
    public ResponseEntity<List<Field>>  getAllFields() {
        try{
             List<Field> f=Field.findAll(fieldRepository);
             return new ResponseEntity<>(f,HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
             return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/field")
    public ResponseEntity<Field> insertField(@RequestBody Field field) {
        try{
            Field fi = Field.saveField(field, fieldRepository);
            return new ResponseEntity<>(fi,HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
