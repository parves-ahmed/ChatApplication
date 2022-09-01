package com.example.websocketserver.Repository;

import com.example.websocketserver.Model.MessageModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<MessageModel, String> {
}
