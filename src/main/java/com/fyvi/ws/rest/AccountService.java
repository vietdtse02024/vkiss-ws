package com.fyvi.ws.rest;
 
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fyvi.ws.bean.User;
import com.fyvi.ws.business.impl.UserManagementImpl;
import com.fyvi.ws.model.UserModel;
 
@Component
@Path("/account")
public class AccountService {
	
	private static final Logger logger = Logger.getLogger(AccountService.class);
	@Autowired
	UserManagementImpl userManagement;
	
	@GET
	@Path("/get-list-friends")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel getListUser() {
		List<User> listUser = userManagement.getListUser();
		User user = new User();
		user.setPersonId(1);
		user.setFirstName("Viet");
		user.setLastName("Dao");
		user.setAddress("Viet Nam");
		user.setCity("Ha Noi");
		listUser.add(user);
		user = new User();
		user.setPersonId(2);
		user.setFirstName("Viet2");
		user.setLastName("Dao2");
		user.setAddress("Viet Nam2");
		user.setCity("Ha Noi2");
		listUser.add(user);
		UserModel model = new UserModel();
		model.setListUser(listUser);
		return model;
 
	}
 
}