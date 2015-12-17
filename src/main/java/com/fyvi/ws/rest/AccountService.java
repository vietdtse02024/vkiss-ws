package com.fyvi.ws.rest;
 
import java.util.List;

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
import com.fyvi.ws.info.view.LocationHistoryView;
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
			if (!userManagement.checkPhoneNo(account.getPhoneNumber())) {
				userManagement.registAccount(account);
			} else {
				model.setErrorMessage("regist.phoneno.exist");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return model;
		
	}
	
	@GET
	@Path("/get-location/{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel getLocation(@PathParam("accountId")String accountId) {
		
		try {
			List<LocationHistoryView> listLocation = userManagement.getLocationView(accountId);
			model.setListLocationHistory(listLocation);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return model;
 
	}
	@GET
	@Path("/get-account-by-id/{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel getAccountById(@PathParam("accountId")String accountId) {
		try {
			Account account = userManagement.findAccountById(accountId);
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