package com.padmavati.microservices.resource;


import com.padmavati.microservices.enitity.User;
import com.padmavati.microservices.model.request.UserRequest;
import com.padmavati.microservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class controller {

    @Autowired
    private UserService userService;

    @GetMapping("/saurabh-weds-anshu")
    public String wedding(){
        return "saurabh weds anshu in 2029";
    }


    @GetMapping("/get-user/{id}")
    public User userData(@PathVariable int id){
        return userService.getData(id);
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<User>> userData(){
        List<User> list =  userService.getAllUsers();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/add-user")
    public ResponseEntity<String> createUser(@RequestBody UserRequest user) {
        String response = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/export-users")
    public ResponseEntity<Resource> exportUsers() {
        ByteArrayInputStream file = null;
        try {
             file = userService.generateExcelForUsers();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.xlsx")
//                .body(file);
        String filename = "data.xlsx";
        InputStreamResource files = new InputStreamResource(file);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(files);

    }

    //request mapping
    //post mapping
    //delete mapping
    //put mapping
}
