package com.example.thymeleaf.dao;

import com.example.thymeleaf.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message,Integer> {
}
