package com.auth0.samples.springwebsockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class MessageController {

    @MessageMapping("/messages")
    @SendTo("/topic/messages")
    public Message greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        Message echoMessage = new Message();
        echoMessage.setMessage(message.getMessage() + "!!!!!!!!");
        return echoMessage;
    }
}
