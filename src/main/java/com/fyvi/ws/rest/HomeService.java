package com.fyvi.ws.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fyvi.ws.business.IUserManagement;
import com.fyvi.ws.info.view.UserFriendsView;
import com.fyvi.ws.model.UserModel;

@Component
@Path("/home")
public class HomeService {
	private static final Logger logger = Logger.getLogger(HomeService.class);
	private IUserManagement userManagement;
	public IUserManagement getUserManagement() {
		return userManagement;
	}
	public void setUserManagement(IUserManagement userManagement) {
		this.userManagement = userManagement;
	}
	
	UserModel model = new UserModel();
	
	@GET
	@Path("/get-list-friends/{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel getListUser(@PathParam("accountId")String accountId) {
		try {
			List<UserFriendsView> listFriends = userManagement.getListFriends(accountId);
			model.setListFriends(listFriends);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return model;
	}
	
	@GET
	@Path("/remove-friends/{accountId}/{accountIdFriend}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel removeFriend(@PathParam("accountId")String accountId, @PathParam("accountIdFriend")String accountIdFriend) {
		try {
			int result = userManagement.removeFriend(accountId, accountIdFriend);
			List<UserFriendsView> listFriends = userManagement.getListFriends(accountId);
			model.setListFriends(listFriends);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return model;
	}
	
	@GET
	@Path("/find-friends/{phoneNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel findFriends(@PathParam("phoneNo")String phoneNo) {
		try {
			UserFriendsView result = userManagement.findFriends(phoneNo);
//			model.setListFriends(listFriends);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return model;
	}
}
