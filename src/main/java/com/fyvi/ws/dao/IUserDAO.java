package com.fyvi.ws.dao;

import java.util.List;

import com.fyvi.ws.bean.User;

public interface IUserDAO<E> extends IBaseDAO<E> {
	public List<User> getListUser();
}
