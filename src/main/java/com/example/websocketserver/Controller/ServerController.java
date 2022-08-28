package com.example.websocketserver.Controller;

import com.example.websocketserver.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class ServerController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String msg){
        System.out.println(msg); 
        return msg;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message chatMessage,
                           SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/room/greeting/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message addUserToRoom( @Payload Message chatMessage,
                                 SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        headerAccessor.getSessionAttributes().put("roomId", chatMessage.getRoomId());
//        chatMessage.setContent("");
//        simpMessagingTemplate.convertAndSend("/topic/room/" + chatMessage.getRoomId(), chatMessage.getContent());
        return chatMessage;
    }

    @MessageMapping("/room/{roomId}")
    public Message sendMessageToRoom(@Payload Message chatMessage) {
        simpMessagingTemplate.convertAndSend("/topic/room" + chatMessage.getRoomId(), chatMessage.getContent());
        return chatMessage;
    }

}
