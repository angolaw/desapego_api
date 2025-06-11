package com.desapego.api.controllers;

import com.desapego.api.dtos.UserDTO;
import com.desapego.api.services.UserService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.accepted().body(createdUser);
    }
    @GetMapping("/fetch")
    public ResponseEntity<ArrayList<UserDTO>> getUsers(){
        ArrayList<UserDTO> allUsers = userService.fetchAll();
        return ResponseEntity.ok(allUsers);
    }
    @GetMapping("/getUserByEmail")
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam String email){
        UserDTO retrievedUser = userService.getUserByEmail(email);
        return ResponseEntity.ok(retrievedUser);
    }
    @PutMapping("/updateUser")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO newData){
        UserDTO updatedUser = userService.updateUser(newData);
        return ResponseEntity.ok(updatedUser);
    }
}
