package com.harsh.userservice.controller;

import com.harsh.userservice.models.User;
import com.harsh.userservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {

    
    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
    @GetMapping(value = "/{userID}")
    public ResponseEntity<?> getUser(@PathVariable("userID") long userID) {
        return ResponseEntity.ok(userRepository.findById(userID));
    }
    
    @PostMapping(value="/register")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        
        return ResponseEntity.ok(userRepository.save(user));
    }
    
    @PutMapping(value="/edit")
    public ResponseEntity<?> editUser(@RequestBody User user) {
		User originalUser = userRepository.findById(user.getUserID()).get();
        originalUser.setContactNumber(user.getContactNumber());
        originalUser.setEmailAddress(user.getEmailAddress());
        originalUser.setPassword(user.getPassword());
        return ResponseEntity.ok(userRepository.save(originalUser));
    }
    
}
