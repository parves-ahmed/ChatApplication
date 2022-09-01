package com.example.websocketserver.Controller;

import com.example.websocketserver.Model.MessageModel;
import com.example.websocketserver.Repository.MessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @PostMapping("/addMessage")
    public ResponseEntity<MessageModel> addMessage(@RequestBody MessageModel messageModel){

        MessageModel msgModel = messageRepository.save(messageModel);
        return ResponseEntity.ok(msgModel);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<MessageModel>> getAllUser(){
        List<MessageModel> messages = messageRepository.findAll();
        return ResponseEntity.ok(messages);
    }
}
