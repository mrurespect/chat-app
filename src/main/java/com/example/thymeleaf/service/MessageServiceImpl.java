package com.example.thymeleaf.service;

import com.example.thymeleaf.dao.MessageDao;
import com.example.thymeleaf.entity.Message;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{
    private final MessageDao messageDao ;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<Message> getMessages(int conversationId) {
        List<Message> allMessages =messageDao.findAll();
        List<Message> messages=new ArrayList<>();
        for (Message message :allMessages) {
            if (message.getConversation().getId()==conversationId){
                messages.add(message);
            }
        }
        return messages;
    }

    @Override
    public void addMessage(Message message) {
        messageDao.save(message);
    }
}
