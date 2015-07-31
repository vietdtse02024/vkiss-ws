package com.fyvi.ws.model;

import java.util.List;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.bean.User;

public class UserModel {
	List<User> listUser;
	Account account;

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
