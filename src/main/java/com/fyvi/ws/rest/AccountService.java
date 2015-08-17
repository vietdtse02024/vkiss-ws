package com.fyvi.ws.rest;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.business.IUserManagement;
import com.fyvi.ws.model.UserModel;
 
@Component
@Path("/account")
public class AccountService {
	
	private static final Logger logger = Logger.getLogger(AccountService.class);
	private IUserManagement userManagement;
	UserModel model = new UserModel();
	
	@GET
	@Path("/check-device-exist/{uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel checkAccountExist(@PathParam("uuid")String uuid) {
		
		try {
			Account account = userManagement.checkAccountExist(uuid);
			model.setAccount(account);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return model;
 
	}
	@POST
	@Path("/regist-account")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserModel registAccount(Account account) {
		try {
			userManagement.registAccount(account);
			model.setAccount(account);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return model;
		
	}

	public IUserManagement getUserManagement() {
		return userManagement;
	}

	public void setUserManagement(IUserManagement userManagement) {
		this.userManagement = userManagement;
	}
 
}