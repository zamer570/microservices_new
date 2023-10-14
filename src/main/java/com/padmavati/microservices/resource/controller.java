package com.padmavati.microservices.resource;


import com.padmavati.microservices.model.request.UserRequest;
import com.padmavati.microservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
public class controller {

    @Autowired
    private UserService userService;

    @GetMapping("/saurabh-weds-anshu")
    public String wedding(){
        return "saurabh weds anshu in 2029";
    }


    @GetMapping("/get-user")
    public String userData(){
        return userService.getData();
    }

    @PostMapping("/add-user")
    public ResponseEntity<String> createUser(@RequestBody UserRequest user) {
        String response = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //request mapping
    //post mapping
    //delete mapping
    //put mapping
}
