package com.fyvi.ws.dao;

import com.fyvi.ws.bean.Account;

public interface IUserDAO<E> extends IBaseDAO<E> {
	public Account findByPhoneNo(String uuid);
	public Integer registAccount(Account account);
}
