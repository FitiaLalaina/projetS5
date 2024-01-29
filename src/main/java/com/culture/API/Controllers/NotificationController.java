package com.culture.API.Controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.Field;
import com.culture.API.Models.MongodbEntity.Notification;
import com.culture.API.Repository.FieldRepository;
import com.culture.API.Repository.NotificationRepository;
import com.culture.API.Repository.OwnerRepository;
import com.culture.API.Utils.HashGenerator;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("/api")
public class NotificationController {
    @Autowired
    private NotificationRepository repository;

    @Autowired
    private FieldRepository fieldrepository;
    
    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/notifications")
    public  ResponseEntity<List<Notification>> getAllNotification() {
        try {
            List<Notification> notifs = Notification.findAll(repository); 
            return new ResponseEntity<>(notifs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/notification")
    public  ResponseEntity<Notification> insertNotif(@RequestBody Notification notif) {

        String hashcode = HashGenerator.generateCode();
        notif.setHashcode(hashcode);

        try {
            notif.setDate(new Timestamp(System.currentTimeMillis()));
            Notification n = repository.save(notif);
            return new ResponseEntity<>(n, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/validate")
    public  ResponseEntity<Field> validateNotif(@RequestParam(value = "hashcode") String hashcode) {
        try {
            Field f = Notification.validate(repository, fieldrepository, ownerRepository, hashcode);
            System.out.println(f + "dsfgfghkdjfgjk");
            return new ResponseEntity<>(f, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/refuse")
    public  ResponseEntity<Object> refuseNotif(@RequestParam(value = "hashcode") String hashcode) {
        try {
            Notification.refuse(repository, hashcode);
            return new ResponseEntity<>("Refused", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
