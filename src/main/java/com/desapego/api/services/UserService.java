package com.desapego.api.services;

import com.desapego.api.dtos.UserDTO;
import com.desapego.api.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        UserDTO createdUser = userRepository.save(userDTO);
        return createdUser;
    }

    public ArrayList<UserDTO> fetchAll() {
        return userRepository.findAll();
    }

    public UserDTO getUserByEmail(String email) {
        UserDTO retrievedUser = userRepository.getUserByEmail(email);
        return retrievedUser;
    }

    public UserDTO updateUser(UserDTO newData) {
        UserDTO updatedUser = userRepository.updateUser(newData);
        return updatedUser;
    }

    public String deleteUser(Long id) {
        String response = userRepository.deleteUser(id);
        return response;
    }
}
