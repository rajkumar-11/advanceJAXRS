package org.koushik.javabrains.rest;

//import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
//@Singleton
public class MyResource {

//	private int count;
//
//	@PathParam("pathParam")
//	private String pathParamExample;
//	@QueryParam("query")
//	private String queryParamExample;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
//		count+=1;
		return "thats  a start";
	}

}
