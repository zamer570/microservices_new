package com.padmavati.microservices.repository;

import com.padmavati.microservices.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String>{

    List<User> findByAge(int age);
}
