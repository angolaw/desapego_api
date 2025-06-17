package com.desapego.api.services;

import com.desapego.api.dtos.Either;
import com.desapego.api.dtos.UserDTO;
import com.desapego.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public Either<String, UserDTO> createUser(UserDTO userDTO) {
        if(getUserByEmail(userDTO.getEmail()) != null){
           return Either.left("An error has ocurred!");
        }
        UserDTO createdUser = userRepository.save(userDTO);
        return Either.right(createdUser);
    }

    public List<UserDTO> fetchAll() {
        return userRepository.findAll();

    }

    public UserDTO getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public UserDTO updateUser(UserDTO newData) {
        return userRepository.updateUser(newData);
    }

    public String deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }
}
