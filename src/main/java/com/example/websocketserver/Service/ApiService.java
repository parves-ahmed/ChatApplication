package com.example.websocketserver.Service;


import com.example.websocketserver.Model.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    private final SimpMessagingTemplate messagingTemplate;

    public ApiService(SimpMessagingTemplate messagingTemplate){
        this.messagingTemplate = messagingTemplate;
    }

    public Message joinRoom(final Message chatMessage){

        return chatMessage;

    }

    private Message handleSimpHeader(Message chatMessage) {
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        headerAccessor.getSessionAttributes().put("roomId", chatMessage.getRoomId());
        return chatMessage;
    }

    public Message sendMessage(Message chatMessage){
        messagingTemplate.convertAndSend("/topic/room/" + chatMessage.getRoomId(), chatMessage.getContent());
        return chatMessage;
    }
}
