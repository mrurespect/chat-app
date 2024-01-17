package com.example.thymeleaf.rest;

import com.example.thymeleaf.entity.*;
import com.example.thymeleaf.service.ConversationService;
import com.example.thymeleaf.service.ConversationUserService;
import com.example.thymeleaf.service.MessageService;
import com.example.thymeleaf.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class DemoController {
    private final UserService userService ;
    private final ConversationService conversationService;
    private final MessageService messageService;
    private final ConversationUserService conversationUserService;

    private  User user =null;
    private Conversation conversation=null;
    private int id =0;
    private String role = Type.normal.toString();

    @Autowired
    DemoController(UserService service, ConversationService conversationService, MessageService messageService, ConversationUserService conversationUserService) {
        this.userService = service;
        this.conversationService = conversationService;
        this.messageService = messageService;
        this.conversationUserService = conversationUserService;
    }

    @GetMapping("/login")
    public String sayHello(Model model,HttpSession session){
        if (session.getAttribute("username")!=null){
            return "redirect:/home";
        }
        model.addAttribute("theDate",new Date());
        return "login";
    }
    @PostMapping("/login")
    public String login(Model model,User user,HttpSession session){
        User userx = userService.getUser(user);
        if (userx !=null){
            this.id=0;
            System.out.println("exist");
            session.setAttribute("username",userx.getUsername());
            session.setAttribute("password",userx.getPassword());
            session.setAttribute("firstname",userx.getName());
            session.setAttribute("lastname",userx.getLastName());
            session.setAttribute("email",userx.getEmail());
            session.setAttribute("userid",userx.getId());
            model.addAttribute("sessionid",session.getId());
            model.addAttribute("error","");
            return "redirect:/home";
        }
            System.out.println("n existe pas");
        model.addAttribute("error","echec d authentification ..");
        return "login";
    }
    @GetMapping("/home")
    public String home(Model model,HttpSession session){
        if (session.getAttribute("username")==null){
            return "redirect:/login";
        }

        int userid=(Integer) session.getAttribute("userid");
        User current =userService.getUser(userid);
        user =current;
        model.addAttribute("current",current);
        System.out.println("user"+current.toString());
        List<Conversation> conversations=conversationService.getConversation(current);
        if (id<conversations.size()){
            this.conversation=conversations.get(id);
        }else  this.conversation=conversations.get(0);


        model.addAttribute("conversation",conversation);
        model.addAttribute("conversations",conversations);
        List<Message> messages=conversation.getMessages();
        String other = null;
        for (Message message:messages) {
            if (!message.getSender().equals(current)){
                other=message.getSender().getName()+" "+message.getSender().getLastName();
                break;
            }
        }
        model.addAttribute("other",other);

        System.out.println(messages.isEmpty());
        model.addAttribute("messages", Objects.requireNonNullElseGet(messages, () -> new ArrayList<Message>()));

        System.out.println(conversation.getId());

        List<ConversationUser> conversationUsers =conversationUserService.find(conversation);
        for (ConversationUser cv:conversationUsers) {
            if (cv.getUser().getId()==user.getId()){
                role=cv.getType().toString();
                break;
            }
        }
        model.addAttribute("role",role);
        return "home";
    }
    @GetMapping("/home/{id}")
    public String home(@PathVariable("id") int id){
        System.out.println("hello"+id);
        this.id=id;
        return "redirect:/home";
    }
    @GetMapping("/remove")
    public  String remove(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        message.setSender(user);
        message.setTime(new Date());
        message.setConversation(conversation);
        messageService.addMessage(message);
        System.out.println("Received message: " + message.getContent());
        return "home";
    }
    @GetMapping("/info")
    public String getInfo(Model model){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("firstname",user.getName());
        model.addAttribute("lastname",user.getLastName());
        model.addAttribute("email",user.getEmail());
        return "info";
    }
    @GetMapping("/")
    public String redirect(){
        return "redirect:/login";
    }
    @GetMapping("/users")
    public String getUsers(Model model){
        //ConversationUser conversationUser =conversationUserService.find(conversation,user);
        List<ConversationUser> conversationUsers =conversationUserService.find(conversation);
        System.out.println("conv user ="+conversationUsers);
        model.addAttribute("conversationUsers",conversationUsers);
        model.addAttribute("role",role);

        return "conversationUsers" ;
    }

    @GetMapping("/bannir/{id}")
    public String bannir(@PathVariable("id") int id){
        User user1 =userService.getUser(id);
        conversationUserService.set(conversation,user1,Type.vue);
        return "redirect:/home";
    }


}
