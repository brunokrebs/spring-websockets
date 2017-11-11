package com.auth0.samples;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Document
public class Message {
	@Id
	private String id;

	@NotNull
	private String user;

	@NotNull
	private Date when;

	@NotNull
	private String message;

	Message() { }

	public Message(String user, String message) {
		this.user = user;
		this.message = message;
		this.when = new Date();
	}
}
