package com.mkyong.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {
	
	@GET
	public String getComment(){
		return "comment resource test";
	}
	@GET
	@Path("/{commentId}")
	public String test(@PathParam("messageId") long id,@PathParam("commentId") long commentId){
		return "comment resource test"+id+"commentid = "+commentId;
	}
}
