package com.auth0.samples;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/messages")
public class MessageController {

	private MessageService messageService;

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping
	public List<Message> getMessages() {
		return messageService.getAll();
	}

	@MessageMapping("/messages")
	public void newMessage(String textMessage) throws Exception {
		messageService.newMessage(new Message("1", textMessage));
	}
}
