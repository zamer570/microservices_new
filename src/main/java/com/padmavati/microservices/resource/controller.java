package com.padmavati.microservices.resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {

    @GetMapping("/saurabh-weds-anshu")
    public String wedding(){
        return "saurabh weds anshu in 2029";
    }

    //request mapping
    //post mapping
    //delete mapping
    //put mapping
}
