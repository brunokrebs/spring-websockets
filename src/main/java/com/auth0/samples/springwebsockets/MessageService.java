package com.auth0.samples.springwebsockets;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private SimpMessagingTemplate template;

    public MessageService(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 5000)
    public void scheduled() {
        template.convertAndSend("/topic/messages", "Hello from STOMP");
        System.out.println("message sent");
    }
}
