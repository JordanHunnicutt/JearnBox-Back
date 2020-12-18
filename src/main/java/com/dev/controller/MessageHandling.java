package com.dev.controller;

import com.dev.model.Greeting;
import com.dev.model.Player;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageHandling {


    @MessageMapping("/user-all")
    @SendTo("/topic/user")
//    @ResponseBody
    public String greet(@Payload String message) throws Exception{
        Thread.sleep(1000);//simulated delay
        System.out.println(message);
        System.out.println("you are connect to the websocket");
        return ("Hello!");
    }

    @MessageMapping("/join")
    @SendTo("/game/players")
    public String playerJoin(@Payload Player p) throws Exception{
//        p.getRoomCode();
        System.out.println(p.toString());
        return ("Hello " + p.getName()+" welcome to the lobby");
    }
}
