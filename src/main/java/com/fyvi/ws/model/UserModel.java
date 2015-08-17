package com.fyvi.ws.model;

import java.util.List;

import com.fyvi.ws.bean.Account;

public class UserModel {
	List<Account> listUser;
	Account account;

	public List<Account> getListUser() {
		return listUser;
	}

	public void setListUser(List<Account> listUser) {
		this.listUser = listUser;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
