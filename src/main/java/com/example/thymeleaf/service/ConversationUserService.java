package com.example.thymeleaf.service;

import com.example.thymeleaf.entity.Conversation;
import com.example.thymeleaf.entity.ConversationUser;
import com.example.thymeleaf.entity.Type;
import com.example.thymeleaf.entity.User;

import java.util.List;

public interface ConversationUserService {
    ConversationUser find(Conversation conversation, User user) ;
    List<ConversationUser> find(Conversation conversation) ;
    void set(Conversation conversation, User user, Type type);

}
