package com.fyvi.ws.rest;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fyvi.ws.business.impl.UserManagementImpl;
import com.fyvi.ws.model.User;
 
@Component
@Path("/hello")
public class HelloWorldService {
	
	private static final Logger logger = Logger.getLogger(HelloWorldService.class);
	@Autowired
	UserManagementImpl userManagement;
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public User getMsg() {
		User user = userManagement.test();
		logger.info("INFO " + user.getName() + " - " + user.getAge());
 
		return user;
 
	}
 
}