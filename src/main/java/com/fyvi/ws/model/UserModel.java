package com.fyvi.ws.model;

import java.util.List;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.info.view.AccountInfo;
import com.fyvi.ws.info.view.LocationHistoryView;
import com.fyvi.ws.info.view.UserFriendsView;

public class UserModel {
	private List<Account> listUser;
	private Account account;
	private List<UserFriendsView> listFriends;
	private String errorMessage;
	private String successMessage;
	private UserFriendsView userFriendsView;
	private List<LocationHistoryView> listLocationHistory;
	private Account friendAccount;
	private AccountInfo accountInfo;
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

	public List<LocationHistoryView> getListLocationHistory() {
		return listLocationHistory;
	}

	public void setListLocationHistory(List<LocationHistoryView> listLocationHistory) {
		this.listLocationHistory = listLocationHistory;
	}

	public Account getFriendAccount() {
		return friendAccount;
	}

	public void setFriendAccount(Account friendAccount) {
		this.friendAccount = friendAccount;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	
}
