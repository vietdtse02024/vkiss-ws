package com.fyvi.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fyvi.ws.business.IFriendManagement;
import com.fyvi.ws.model.UserModel;

@Component
@Path("/friend")
public class FriendService {
	private static final Logger log = Logger.getLogger(FriendService.class);
	private IFriendManagement friendManagement;
	UserModel model = new UserModel();
	public IFriendManagement getFriendManagement() {
		return friendManagement;
	}
	public void setFriendManagement(IFriendManagement friendManagement) {
		this.friendManagement = friendManagement;
	}
	
	@GET
	@Path("/add-friend/{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel checkAccountExist(@PathParam("accountId")String accountId) {
		log.info("Start add new friend: " + accountId);
		try {
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return model;
 
	}
}
