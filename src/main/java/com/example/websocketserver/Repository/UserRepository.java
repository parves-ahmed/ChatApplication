package com.example.websocketserver.Repository;


import com.example.websocketserver.Dto.UserDto;
import com.example.websocketserver.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
    Optional<UserModel> findByUsername(String userName);
    Optional<UserModel> findByUsernameAndPassword(UserDto userDto);
}
