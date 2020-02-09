package com.Irene.events.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Irene.events.model.Message;
import com.Irene.events.repository.MessageRepository;

@Service
public class MessageService {
	private final MessageRepository messageRepository;
	
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	public List<Message> findAllMessages(){
		return messageRepository.findAll();
	}
	
	public Message findMessage(Long id) {
		Optional <Message> optionalMessage = messageRepository.findById(id);
		if(optionalMessage.isPresent()) {
			return optionalMessage.get();
		} else {
			return null;
		}
	}
	
	public Message createMessage(Message b) {
		return messageRepository.save(b);
	}
	
	public void deleteMessage(Long id) {
		messageRepository.deleteById(id);
	}
	
	public Message updateMessage(Message message) {
		messageRepository.save(message);
		return null;
	}
	
}
