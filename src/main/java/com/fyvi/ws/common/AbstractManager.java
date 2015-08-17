package com.fyvi.ws.common;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.dao.IUserDAO;

public class AbstractManager {
	IUserDAO<Account> userDAO;

	public IUserDAO<Account> getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO<Account> userDAO) {
		this.userDAO = userDAO;
	}
	
}
