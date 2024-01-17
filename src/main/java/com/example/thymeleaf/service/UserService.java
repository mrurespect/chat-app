package com.example.thymeleaf.service;

import com.example.thymeleaf.entity.Conversation;
import com.example.thymeleaf.entity.User;

public interface UserService {
    User getUser(User user);
    User getUser(int id);
}
