6:01 PM

6:06 PM
in web.xml
param value define the package to allocate the resource endpoint.
6:19 PM
@produces define the response formate
6:24 PM
http://localhost:8080/Messanger/messages
http://192.168.0.206:8080/Messanger/messages
http://192.168.0.206:8080
6:50 PM
(R). Each model class should have a NULL constructer
for xml and json conversion
6:57 PM
javax.ws.rs.WebApplicationException: com.sun.jersey.api.MessageException: A message body writer for Java class java.util.ArrayList, and Java type java.util.List<com.mkyong.rest.model.Message>, and MIME media type application/xml was not found
add annotation with your model to convert automatically in XML or JSON response to your model:
e.g.
@XmlRootElement
public class Message {
	private long id;
	private String message;
	private String auther;
	private Date created;
}
10:24 PM
Remember if we make any constructer form my side then Make default constructer also.
11:17 AM
Adding path branch
@Path("/messages")
public class MessageResources {
	MessageService messageServices = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage(){
		return messageServices.getAllMessages();
	}
	@GET
	@Path("/akash")
	@Produces(MediaType.TEXT_PLAIN)
	public String getName(){
		return "akash soni";
	}
}


eg: message/akash
Map variable path

@Path("/messages")
public class MessageResources {
	MessageService messageServices = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage(){
		return messageServices.getAllMessages();
	}
	@GET
	@Path("{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getName(){
		return "akash soni";
	}
}
11:32 AM
Path params
	@GET
	@Path("{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getName(@PathParam("messageId") String messageId){
		return messageId;
	}
for give parameters to methoods
11:51 AM
Add dependency in pom.xml for automatic conversion to json


Maven Repository: org.json » json » 20090211
https://mvnrepository.com

12:09 PM

Maven Repository: org.glassfish.jersey.media » jersey-media-moxy » 2.28
https://mvnrepository.com
1:34 PM
correct dependency for json
https://www.mkyong.com/webservices/jax-rs/json-example-with-jersey-jackson/

JSON example with Jersey + Jackson – Mkyong.com
https://www.mkyong.com
3:43 PM
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageServices.addMessage(message);
	}
Don't forgot to change application/ type to json in POSTMAN
7:05 PM
Write consume and produce annotation for avoiding it from each methods
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResources {
	MessageService messageServices = new MessageService();
	@GET
	public List<Message> getMessage(@QueryParam("year") int year){
		if(year>0){
			return messageServices.getAllMessagesForYear(year);
		}
		return messageServices.getAllMessages();
	}
	
}
7:11 PM
Code for Query params
	@GET
	public List<Message> getMessage(@QueryParam("year") int year){
		if(year>0){
			return messageServices.getAllMessagesForYear(year);
		}
		return messageServices.getAllMessages();
	}
e.g. http://localhost:8080/messanger/messages?year=2018



Similarly for   http://localhost:8080/messanger/messages?year=2019&start=1&end=5
Multi Query params
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
8:27 PM
Some other params
@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DemoTest {
	@GET
	@Path("annotation")
	public String getMessage(
			@MatrixParam("matrixParams") String matrixParams,
			@HeaderParam("hadderParams") String hadderParams,
			@CookieParam("cookiParams") String cookiParams
							){
		return "matrix="+matrixParams+"hadder = "+hadderParams+"cookie = "+cookiParams;
	}
}
8:34 PM
Here is how bean params class looks
public class MessageFilterBean {
	@QueryParam("year") int year;
	@QueryParam("start") int start;
	@QueryParam("end") int end;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
}
12:18 PM
	
Sub params	
@Path("/{messageId}/comments")
	public CommentResource getCommentResource(@PathParam("messageId") long id){
		return new CommentResource();
	}




///////////////////////?
/setrole 
@Path("/")
public class CommentResource {
	
	@GET
	public String getComment(){
		return "comment resource test";
	}
	
}


For making class path and its own  params
*we can add param form super resource class.
*
e.g.
	@GET
	@Path("/{commentId}")
	public String test(@PathParam("messageId") long id,@PathParam("commentId") long commentId){
		return "comment resource test"+id+"commentid = "+commentId;
	}
http://localhost:8080/messanger/messages/1/comments/1
CONVERSATION MEMBERS:
   live:akashsoni8285: Admin
