package com.example.websocketserver.Controller;

import com.example.websocketserver.Dto.UserDto;
import com.example.websocketserver.Model.UserModel;
import com.example.websocketserver.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel){
        UserModel user = userRepository.save(userModel);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUser(){
        List<UserModel> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<UserModel>> findUserById(@PathVariable String userId){
        Optional<UserModel> user = userRepository.findById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<Optional<UserModel>> findUserByName(@PathVariable String userName){
        Optional<UserModel> user = userRepository.findByUsername(userName);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/findUser")
    public ResponseEntity<Optional<UserModel>> getUser(@RequestBody UserDto userDto){
        Optional<UserModel> user = userRepository.findByUsernameAndPassword(userDto);
        return ResponseEntity.ok(user);
    }
}
