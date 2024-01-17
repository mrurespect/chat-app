package com.example.thymeleaf.dao;

import com.example.thymeleaf.entity.Conversation;
import com.example.thymeleaf.entity.ConversationUser;
import com.example.thymeleaf.entity.Type;
import com.example.thymeleaf.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConversationUserDaoImpl implements ConversationUserDao {
     private final EntityManager entityManager ;


     public ConversationUserDaoImpl(EntityManager entityManager) {
          this.entityManager = entityManager;
     }

     @Override
     public ConversationUser find(Conversation conversation, User user) {
          TypedQuery<ConversationUser> query = entityManager.createQuery(
                  "SELECT cu FROM ConversationUser cu WHERE cu.conversation = :conversation AND cu.user = :user",
                  ConversationUser.class);

          query.setParameter("conversation", conversation);
          query.setParameter("user", user);

          try {
               return query.getSingleResult();
          } catch (NoResultException e) {
               return null;
          }
     }

     @Override
     public List<ConversationUser> find(Conversation conversation) {
          TypedQuery<ConversationUser> query = entityManager.createQuery(
                  "SELECT cu FROM ConversationUser cu WHERE cu.conversation = :conversation",
                  ConversationUser.class);
          query.setParameter("conversation", conversation);
          try {
               return query.getResultList();
          } catch (NoResultException e) {
               return null;
          }
     }
     @Override
     public void set(Conversation conversation, User user, Type type) {
          TypedQuery<ConversationUser> query = entityManager.createQuery(
                  "SELECT cu FROM ConversationUser cu WHERE cu.conversation = :conversation AND cu.user = :user",
                  ConversationUser.class);

          query.setParameter("conversation", conversation);
          query.setParameter("user", user);

          ConversationUser conversationUser =query.getSingleResult();
          conversationUser.setType(type);

          entityManager.merge(conversationUser);
     }
}
