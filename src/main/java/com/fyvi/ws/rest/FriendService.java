package com.fyvi.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fyvi.ws.bean.RelationShip;
import com.fyvi.ws.business.IFriendManagement;
import com.fyvi.ws.model.UserModel;

@Component
@Path("/friends")
public class FriendService {
	private static final Logger log = Logger.getLogger(FriendService.class);
	private IFriendManagement friendManager;
	UserModel model = new UserModel();
	public IFriendManagement getFriendManager() {
		return friendManager;
	}
	public void setFriendManager(IFriendManagement friendManager) {
		this.friendManager = friendManager;
	}

	@GET
	@Path("/add-friend/{accountId}/{accountIdFriend}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel addFriend(@PathParam("accountId")String accountId, @PathParam("accountIdFriend")String accountIdFriend) {
		log.info("Start add new friend: " + accountId + " and " + accountIdFriend);
		try {
			RelationShip relationShip = friendManager.getRelationShip(accountId, accountIdFriend);
			if (relationShip != null) {
				friendManager.requestFriend(accountId, accountIdFriend);
			} else {
				friendManager.addNewFriend(accountId, accountIdFriend);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return model;
 
	}
}
