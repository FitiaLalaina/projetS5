package com.culture.API.Controllers.Front;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.Owner;
import com.culture.API.Models.DTO.OwnerDTO;
import com.culture.API.Models.MongodbEntity.Message;
import com.culture.API.Repository.MessageRepository;
import com.culture.API.Repository.OwnerRepository;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("/api")
public class WebSocketController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private OwnerRepository ownerRepository;


    private final SimpMessagingTemplate messagingTemplate;
    private final MongoTemplate mongoTemplate;


    public WebSocketController(SimpMessagingTemplate messagingTemplate, MongoTemplate mongoTemplate) {
        this.messagingTemplate = messagingTemplate;
        this.mongoTemplate = mongoTemplate;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message)
    {
        //Save message to MongoDB
        //Your  MongoDB integreation logic here
        try {
            messageRepository.save(message);
        } catch (Exception e) {
            
        }
        return message;
    }

    @PostMapping("/message")
    public ResponseEntity<Message> sendRestMessage(@RequestBody Message message) {
        // Your logic for handling REST API messages
        // You can handle this similar to WebSocket messages
        
        // Here, you can send the message to the WebSocket topic
        Message m = null;
        Owner sender = ownerRepository.findByidOwner(message.getIdSender());
        OwnerDTO senderDTO = new OwnerDTO(sender.getIdOwner(), sender.getName(), sender.getEmail());
        Owner receiver = ownerRepository.findByidOwner(message.getIdReceiver());
        OwnerDTO receiverDTO = new OwnerDTO(receiver.getIdOwner(), receiver.getName(), receiver.getEmail());


        message.setSenderObject(senderDTO);
        message.setReceiverObject(receiverDTO);
        message.setDate(new Date());

        try {
            m = messageRepository.save(message);
            messagingTemplate.convertAndSend("/topic/messages", m);
            return new ResponseEntity<>(m, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(m, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    @GetMapping("/messages")
    public List<Message> findMessage(@RequestParam(value = "p1") int p1, @RequestParam(value = "p2") int p2)
    {
        Query query = new Query();
        query.addCriteria(
            new Criteria().orOperator(
                Criteria.where("idSender").is(p1).and("idReceiver").is(p2),
                Criteria.where("idSender").is(p2).and("idReceiver").is(p1)
            )
        );
        return mongoTemplate.find(query, Message.class);
    }
    
}
