package com.fyvi.ws.business;

import java.util.List;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.bean.User;

public interface IUserManagement {
	public List<User> getListUser();
	public Account checkAccountExist(String phoneNo);
	public Integer registAccount(Account account) throws Exception;
}
