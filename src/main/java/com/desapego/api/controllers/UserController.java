package com.desapego.api.controllers;

import com.desapego.api.dtos.Either;
import com.desapego.api.dtos.UserDTO;
import com.desapego.api.services.UserService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Either<String, UserDTO>> createUser(@Valid @RequestBody UserDTO userDTO){
        Either<String, UserDTO> createdUser = userService.createUser(userDTO);
        if(createdUser.getLeft() != null){
            return ResponseEntity.status(404).body(createdUser);
        }
        return ResponseEntity.accepted().body(createdUser);
    }
    @GetMapping("/fetch")
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> allUsers = userService.fetchAll();
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        String response = userService.deleteUser(id);
        return ResponseEntity.ok(response);
    }
}
