package com.fyvi.ws.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fyvi.ws.bean.User;
import com.fyvi.ws.business.IUserManagement;
import com.fyvi.ws.model.UserModel;

@Component
@Path("/home")
public class HomeService {
	private static final Logger logger = Logger.getLogger(AccountService.class);
	private IUserManagement userManagement;
	public IUserManagement getUserManagement() {
		return userManagement;
	}
	public void setUserManagement(IUserManagement userManagement) {
		this.userManagement = userManagement;
	}
	
	UserModel model = new UserModel();
	@GET
	@Path("/get-list-friends")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel getListUser() {
		try {
			List<User> listUser = userManagement.getListUser();
			model.setListUser(listUser);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return model;
	}
}
