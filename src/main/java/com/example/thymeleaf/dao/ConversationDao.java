package com.example.thymeleaf.dao;

import com.example.thymeleaf.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationDao extends JpaRepository<Conversation,Integer> {
}
