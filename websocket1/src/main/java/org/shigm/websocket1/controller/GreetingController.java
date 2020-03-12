package org.shigm.websocket1.controller;

import org.shigm.websocket1.bean.Chat;
import org.shigm.websocket1.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author shigm
 * @date 2019/11/24 22:03
 */
@Controller
public class GreetingController {


    @Autowired
    SimpMessagingTemplate template;

//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Message greeting(Message message) {
//        return message;
//    }

    @MessageMapping("/hello")
    public void greeting(Message message) {
        template.convertAndSend("/topic/greetings",message);
    }

    @MessageMapping("/chat")
    public void  chat(Principal principal, Chat chat) {
        chat.setFrom(principal.getName());
        template.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
    }
}
