package com.fyvi.ws.dao.impl;

import java.util.List;

import com.fyvi.ws.bean.User;
import com.fyvi.ws.dao.IUserDAO;

public class UserDAOImpl extends BaseHelperDAO<User> implements IUserDAO<User>{

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser() {
		List<User> listUser = getHibernateTemplate().find("from User");
		return listUser;
	}

}
