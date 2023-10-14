package com.padmavati.microservices.service;

import com.padmavati.microservices.enitity.User;
import com.padmavati.microservices.model.request.UserRequest;
import com.padmavati.microservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String getData(){
        return "";
    }

    public String addUser(UserRequest user){
        User u = User.builder()
                .age(user.getAge())
                .name(user.getName())
                .designation(user.getDesignation()).build();
        userRepository.save(u);
        return "User added successfully";
    }

}
