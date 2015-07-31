package com.fyvi.ws.dao.impl;

import java.util.List;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.bean.User;
import com.fyvi.ws.dao.IUserDAO;

@SuppressWarnings("unchecked")
public class UserDAOImpl extends BaseHelperDAO<User> implements IUserDAO<User>{
	@Override
	public List<User> getListUser() {
		List<User> listUser = getHibernateTemplate().find("from User");
		return listUser;
	}

	@Override
	public Account findByPhoneNo(String phoneNo) {
		List<Account> listUser = getHibernateTemplate().find("from Account where phoneNumber = ? and activeFlg = 1", phoneNo);
		if (listUser != null && listUser.size() > 0) {
			return listUser.get(0);
		}
		return null;
	}

}
