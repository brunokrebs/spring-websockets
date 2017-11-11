package com.auth0.samples;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

	private static final String MESSAGES_TOPIC = "/topic/messages";

	private SimpMessagingTemplate template;
	private MessageRepository messageRepository;

	public MessageService(SimpMessagingTemplate template, MessageRepository messageRepository) {
		this.template = template;
		this.messageRepository = messageRepository;
	}

	List<Message> getAll() {
		return messageRepository.findAll();
	}

	void newMessage(Message message) {
		messageRepository.insert(message);
		template.convertAndSend(MESSAGES_TOPIC, message);
	}
}
