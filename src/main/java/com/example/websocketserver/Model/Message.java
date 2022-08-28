package com.example.websocketserver.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
    private MessageType type;
    private String content;
    private String sender;
    private String roomId;
    private String receiver;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
