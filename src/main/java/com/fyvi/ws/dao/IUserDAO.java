package com.fyvi.ws.dao;

import java.util.List;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.bean.User;

public interface IUserDAO<E> extends IBaseDAO<E> {
	public List<User> getListUser();
	public Account findByPhoneNo(String uuid);
	public Integer registAccount(Account account);
}
