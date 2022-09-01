package com.example.websocketserver.Controller;

import com.example.websocketserver.Model.Message;
import com.example.websocketserver.Service.ApiService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService){
        this.apiService = apiService;
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody Message chatMessage){
        apiService.sendMessage(chatMessage);
    }

   @PostMapping("/join")
    public void joinRoom(@RequestBody final Message chatMessage){
        apiService.joinRoom(chatMessage);
    }
}
