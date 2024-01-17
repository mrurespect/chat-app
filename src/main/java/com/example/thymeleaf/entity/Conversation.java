package com.example.thymeleaf.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String nom ;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @OneToMany(mappedBy = "conversation",fetch = FetchType.EAGER)
    private List<Message> messages;
    @ManyToMany
    @JoinTable(name = "conversation_users",
                joinColumns = @JoinColumn(name = "conversations_id"),
                 inverseJoinColumns= @JoinColumn(name = "users_id")
    )

    private  List<User> users;
    public void addUser(User user){
        if (users==null){
            users=new ArrayList<>();
        }
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Conversation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message){
        if (messages==null){
            messages=new ArrayList<>();
        }
        messages.add(message);
    }
}
