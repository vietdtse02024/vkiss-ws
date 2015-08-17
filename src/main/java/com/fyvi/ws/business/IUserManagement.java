package com.fyvi.ws.business;

import com.fyvi.ws.bean.Account;

public interface IUserManagement {
	public Account checkAccountExist(String uuid);
	public Integer registAccount(Account account) throws Exception;
}
