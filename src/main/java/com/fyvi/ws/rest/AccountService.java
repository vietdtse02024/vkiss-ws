package com.fyvi.ws.rest;
 
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.bean.User;
import com.fyvi.ws.business.IUserManagement;
import com.fyvi.ws.common.MD5Encrypt;
import com.fyvi.ws.model.UserModel;
 
@Component
@Path("/account")
public class AccountService {
	
	private static final Logger logger = Logger.getLogger(AccountService.class);
	private IUserManagement userManagement;
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
	
	@GET
	@Path("/check-account-exist/{phoneNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel checkAccountExist(@PathParam("phoneNo")String phoneNo) {
		
		try {
			Account account = userManagement.checkAccountExist(phoneNo);
			model.setAccount(account);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return model;
 
	}
	@GET
	@Path("/regist-account/{phoneNo}/{fullName}/{accountName}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel registAccount(@PathParam("phoneNo")String phoneNo,@PathParam("fullName")String fullName, @PathParam("accountName")String accountName, @PathParam("password")String password) {
		
		try {
			Account account = new Account();
			account.setPhoneNumber(phoneNo);
			account.setFullName(fullName);
			account.setAccountName(accountName);
			account.setPassword(MD5Encrypt.crypt(password));
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