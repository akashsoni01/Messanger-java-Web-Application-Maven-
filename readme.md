6:05 PM
https://www.geeksforgeeks.org/java-net-uri-class-java/

Java.net.URI class in Java - GeeksforGeeks
https://www.geeksforgeeks.org


6:23 PM

REST Resource Identifier (URI) Naming – REST API Tutorial
https://restfulapi.net
6:28 PM
create -> post
put -> update
delete ->. delete
collection uri for many data
e.g : post - msg/10/comments
create a new comment for ten messages
CRUD

7:12 PM

List of HTTP status codes
https://en.wikipedia.org
8:52 PM
Steps

Open Eclipse
Choose New > Project > Maven Project
Choose Add Archetype and enter the following details:
Archetype Group ID: org.glassfish.jersey.archetypes
Archetype Artifact ID: jersey-quickstart-webapp
Archetype Version: 2.16 [enter the latest version that is available]
Choose the newly entered archetype from the Archetype selection screen
Enter your project details - Group ID, Artifact ID and Version.
More Information: https://javabrains.io/courses/javaee_jaxrs/lessons/Setting-Up

Setting Up | Developing REST APIs with JAX-RS | Java Brains
https://javabrains.io

9:17 PM

How to install maven to mac using terminal without using brew
https://stackoverflow.com


An internal error occurred during: "Updating Maven Project
https://stackoverflow.com

9:41 PM

https://start.spring.io
https://start.spring.io


Spring Projects
http://spring.io


Jersey hello world example – Mkyong.com
https://www.mkyong.com
3:17 PM
localhost:8080/RESTfulExample/hello/hey


3:24 PM
or go to server and debug run
	<servlet-mapping>
		<servlet-name>jersey-serlvet</servlet-name>
		<url-pattern>/*</url-pattern>
	</servlet-mapping>
		<finalName>RESTfulExample</finalName>
@Path("/hello")
3:46 PM
prefixlen 64 secured scopeid 0x6 
	inet 192.168.0.206 netmask
Command for Terminal:
ifconfig
http://192.168.0.206:8080/RESTfulExample/hello/hey

5:18 PM

RESTful Web Service - JAX-RS Annotations
http://www.techferry.com


Hibernate Tutorial Part 1 - Introduction to Hibernate ( Concept) - YouTube
https://www.youtube.com
5:43 PM
http://localhost:8080/Messanger/hello/hey
http://192.168.0.206:8080/Messanger/hello/hey

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
