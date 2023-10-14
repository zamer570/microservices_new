package com.padmavati.microservices.repository;

import com.padmavati.microservices.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>{
}
