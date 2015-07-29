package com.fyvi.ws.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fyvi.ws.bean.User;
import com.fyvi.ws.dao.IUserDAO;

public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser() {
		List<User> listUser = getHibernateTemplate().find("from persons");
		return listUser;
	}

}
