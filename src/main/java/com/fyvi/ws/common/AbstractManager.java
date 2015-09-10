package com.fyvi.ws.common;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.dao.ILocationHisDAO;
import com.fyvi.ws.dao.IUserDAO;

public class AbstractManager {
	IUserDAO<Account> userDAO;
	ILocationHisDAO<Account> locationHisDAO;

	public IUserDAO<Account> getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO<Account> userDAO) {
		this.userDAO = userDAO;
	}

	public ILocationHisDAO<Account> getLocationHisDAO() {
		return locationHisDAO;
	}

	public void setLocationHisDAO(ILocationHisDAO<Account> locationHisDAO) {
		this.locationHisDAO = locationHisDAO;
	}
	
}
