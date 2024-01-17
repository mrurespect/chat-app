package com.example.thymeleaf.service;

import com.example.thymeleaf.entity.Conversation;
import com.example.thymeleaf.entity.User;

import java.util.List;

public interface ConversationService {
    List<Conversation> getConversation(User user);
}
