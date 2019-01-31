package com.mkyong.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mkyong.rest.model.Message;
import com.mkyong.rest.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResources {
	MessageService messageServices = new MessageService();
	@GET
	public List<Message> getMessage(@QueryParam("year") int year,
									@QueryParam("start") int start,
									@QueryParam("end") int end){
		if(year>0){
			return messageServices.getAllMessagesForYear(year);
		}
		
		//write your logic for start and end id of messages
		return messageServices.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId){
		return messageServices.getMessage(messageId);
	}
	
	@POST
	public Message addMessage(Message message){
		return messageServices.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") Long messageId,Message message){
		message.setId(messageId);
		return messageServices.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") Long messageId){
		messageServices.removeMessage(messageId);
	}
	
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(@PathParam("messageId") long id){
		return new CommentResource();
	}
}
