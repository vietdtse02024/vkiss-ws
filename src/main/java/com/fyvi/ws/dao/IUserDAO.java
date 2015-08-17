package com.fyvi.ws.dao;

import java.util.List;

import com.fyvi.ws.bean.Account;

public interface IUserDAO<E> extends IBaseDAO<E> {
	public Account findByUuid(String uuid);
	public Integer registAccount(Account account);
	public List<Account> getListFriends(String accountId);
}
