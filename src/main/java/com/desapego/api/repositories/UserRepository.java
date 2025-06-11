package com.desapego.api.repositories;

import com.desapego.api.dtos.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private ArrayList<UserDTO> users = new ArrayList<>();


    public UserDTO save(UserDTO userDTO) {

        Random randomGenerator = new Random();

        Long randomLongValue = randomGenerator.nextLong();
        userDTO.setId(randomLongValue);
        users.add(userDTO);
        return userDTO;
    }

    public ArrayList<UserDTO> findAll() {
        return users;
    }

    public UserDTO getUserByEmail(String email) {
        for (UserDTO user: users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public UserDTO updateUser(UserDTO newData) {
        for (int i= 0; i < users.size(); i++){
            if(users.get(i).getEmail().equals(newData.getEmail())){
                UserDTO userToUpdate = users.get(i);
                userToUpdate.setName(newData.getName());
                userToUpdate.setEmail(newData.getEmail());
                userToUpdate.setTelephoneNumber(newData.getTelephoneNumber());
                users.set(i, userToUpdate);
                return userToUpdate;
            }
        }
        return null;
    }

    public String deleteUser(Long id) {
        boolean removed =  users.removeIf(user -> user.getId().equals(id));
        return removed ? "Usuário com id "+id+" deletado" : "Não foram encontrados registros";
    }
}
