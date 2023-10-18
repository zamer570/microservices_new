package com.padmavati.microservices.model.request;

import com.padmavati.microservices.enitity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequest{
    private String name;

    private String designation;

    private int age;

    private String state;

    private boolean active;
}
