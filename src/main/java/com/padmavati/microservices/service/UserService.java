package com.padmavati.microservices.service;

import com.padmavati.microservices.enitity.User;
import com.padmavati.microservices.exception.ResourceNotFoundException;
import com.padmavati.microservices.model.request.UserRequest;
import com.padmavati.microservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User getData(int id){
       return userRepository.findById(String.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("id provided is not present please recheck your id!"));
    }

    public List<User> getUsersByAge(int age){
        return userRepository.findByAge(age);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
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
