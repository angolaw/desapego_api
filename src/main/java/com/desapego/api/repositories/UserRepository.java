package com.desapego.api.repositories;

import com.desapego.api.dtos.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class UserRepository {
    private final List<UserDTO> users = new ArrayList<>();
    Random randomGenerator = new Random();
    Long randomLongValue = null;
    public void initializeRamdomness(){
        randomLongValue = randomGenerator.nextLong();
    }


    public UserDTO save(UserDTO userDTO) {
        initializeRamdomness();

        userDTO.setId(randomLongValue);
        users.add(userDTO);
        return userDTO;
    }

    public List<UserDTO> findAll() {
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
            if(users.get(i).getId().equals(newData.getId())){
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
