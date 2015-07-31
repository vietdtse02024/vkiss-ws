package com.fyvi.ws.business.impl;

import java.util.List;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.bean.User;
import com.fyvi.ws.business.IUserManagement;
import com.fyvi.ws.common.AbstractManager;

public class UserManagementImpl extends AbstractManager implements IUserManagement{

	@Override
	public List<User> getListUser() {
		List<User> listUser = getUserDAO().getListUser();
		return listUser;
	}

	@Override
	public Account checkAccountExist(String phoneNo) {
		Account account = getUserDAO().findByPhoneNo(phoneNo);
		return account;
	}

}
