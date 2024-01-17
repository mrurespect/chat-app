package com.example.thymeleaf.service;

import com.example.thymeleaf.dao.ConversationDao;
import com.example.thymeleaf.entity.Conversation;
import com.example.thymeleaf.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService{
    private final ConversationDao conversationDao;

    public ConversationServiceImpl(ConversationDao conversationDao) {
        this.conversationDao = conversationDao;
    }

    @Override
    public List<Conversation> getConversation(User user) {
        List<Conversation> conversations=conversationDao.findAll();
        List<Conversation> filtredConversations=new ArrayList<>();
        for (Conversation conversation :conversations) {
           if (conversation.getUsers().contains(user)){
               System.out.println("contains");
               filtredConversations.add(conversation);
            }
        }
        return filtredConversations;
    }
}
