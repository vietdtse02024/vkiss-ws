package com.fyvi.ws.common;

import com.fyvi.ws.bean.User;
import com.fyvi.ws.dao.IUserDAO;

public class AbstractManager {
	IUserDAO<User> userDAO;

	public IUserDAO<User> getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO<User> userDAO) {
		this.userDAO = userDAO;
	}
	
}
