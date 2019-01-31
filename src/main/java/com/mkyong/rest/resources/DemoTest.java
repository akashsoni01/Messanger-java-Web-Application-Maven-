package com.mkyong.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mkyong.rest.model.Message;

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
