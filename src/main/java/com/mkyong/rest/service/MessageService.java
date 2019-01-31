package com.mkyong.rest.service;
import java.util.*;

import com.mkyong.rest.model.Message;

import com.mkyong.rest.database.Database;
import com.mkyong.rest.model.*;

public class MessageService {
	private Map<Long,Message> messages = Database.getMessage();
	
	public  MessageService(){
		this.messages.put(1L, new Message(1,"hello world","Akash soni"));
		this.messages.put(2L, new Message(2,"hello world","Akash fonsi"));
	}
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	public Message getMessage(long id){
		return messages.get(id);
	}
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return  message;
	}
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> sortedMessages = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(cal.YEAR) == year){
				sortedMessages.add(message);
			}
		}
		return sortedMessages;
	}
}
