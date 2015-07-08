package com.fyvi.ws.business.impl;

import com.fyvi.ws.business.IUserManagement;
import com.fyvi.ws.model.User;

public class UserManagementImpl implements IUserManagement{

	@Override
	public User test() {
		User user = new User();
		user.setName("Viet Dao");
		user.setAge(24);
		return user;
	}

}
