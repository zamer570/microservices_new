package com.padmavati.microservices.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("requested value is not present");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

}
