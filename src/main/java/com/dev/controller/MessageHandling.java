package com.dev.controller;

import com.dev.model.Greeting;
import com.dev.model.Player;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageHandling {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Player message) throws Exception{
        Thread.sleep(1000);//simulated delay
        return new Greeting("Hello "+ HtmlUtils.htmlEscape(message.getName())+"!");
    }
}
