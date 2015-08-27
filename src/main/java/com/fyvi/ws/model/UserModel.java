package com.fyvi.ws.model;

import java.util.List;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.info.view.UserFriendsView;

public class UserModel {
	List<Account> listUser;
	Account account;
	List<UserFriendsView> listFriends;
	String errorMessage;
	UserFriendsView userFriendsView;

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

	public List<UserFriendsView> getListFriends() {
		return listFriends;
	}

	public void setListFriends(List<UserFriendsView> listFriends) {
		this.listFriends = listFriends;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public UserFriendsView getUserFriendsView() {
		return userFriendsView;
	}

	public void setUserFriendsView(UserFriendsView userFriendsView) {
		this.userFriendsView = userFriendsView;
	}
	
}
