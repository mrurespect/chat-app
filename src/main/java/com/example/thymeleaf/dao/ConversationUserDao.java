package com.example.thymeleaf.dao;

import com.example.thymeleaf.entity.Conversation;
import com.example.thymeleaf.entity.ConversationUser;
import com.example.thymeleaf.entity.Type;
import com.example.thymeleaf.entity.User;

import java.util.List;

public interface ConversationUserDao {
     public void set(Conversation conversation, User user, Type type) ;

          ConversationUser find(Conversation conversation, User user) ;
     List<ConversationUser> find(Conversation conversation) ;
}
