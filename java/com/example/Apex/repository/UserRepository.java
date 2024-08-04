package com.example.Apex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Apex.entity.User;
public interface UserRepository extends JpaRepository<User, Integer> {


    User findByUsername(String username);

}
