package com.example.thymeleaf.service;

import com.example.thymeleaf.dao.MessageDao;
import com.example.thymeleaf.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message>  getMessages(int conversationId);
    void addMessage(Message message);
}
