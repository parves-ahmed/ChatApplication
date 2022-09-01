package com.example.websocketserver.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageModel {
    @Id
    private String id;
    private String content;
    private String sender;
    private String roomId;
    private String receiver;
}
