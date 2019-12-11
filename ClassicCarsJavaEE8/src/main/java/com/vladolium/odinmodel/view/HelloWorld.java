package com.vladolium.odinmodel.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.vladolium.odinmodel.model.Message;
import com.vladolium.odinmodel.service.MessageService;

@Named
@RequestScoped
public class HelloWorld {
	
	private Message message = new Message();
	private List<Message> messages;
	@Inject
	private MessageService messageService;

	@PostConstruct
	public void init() {
		messages = messageService.list();
	}

	public void submit() {
		messageService.create(message);
		messages.add(message);
	}

	public Message getMessage() {
		return message;
	}

	public List<Message> getMessages() {
		return messages;
	}
}
