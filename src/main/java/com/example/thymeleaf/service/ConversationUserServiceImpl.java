package com.example.thymeleaf.service;

import com.example.thymeleaf.dao.ConversationUserDao;
import com.example.thymeleaf.entity.Conversation;
import com.example.thymeleaf.entity.ConversationUser;
import com.example.thymeleaf.entity.Type;
import com.example.thymeleaf.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConversationUserServiceImpl implements ConversationUserService {
    private final ConversationUserDao conversationUserDao;

    public ConversationUserServiceImpl(ConversationUserDao conversationUserDao) {
        this.conversationUserDao = conversationUserDao;
    }

    @Override
    public ConversationUser find(Conversation conversation, User user) {
        return conversationUserDao.find(conversation,user);
    }

    @Override
    public List<ConversationUser> find(Conversation conversation) {
        return conversationUserDao.find(conversation);
    }
    @Override
    @Transactional
    public void set(Conversation conversation, User user, Type type) {
        conversationUserDao.set(conversation,user,type);
    }

    }
