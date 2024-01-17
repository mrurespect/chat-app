package com.example.thymeleaf.dao;

import com.example.thymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

}
