package com.fyvi.ws.business;

import java.util.List;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.info.view.AccountInfo;
import com.fyvi.ws.info.view.LocationHistoryView;
import com.fyvi.ws.info.view.UserFriendsView;

public interface IUserManagement {
	public Account checkAccountExist(String uuid);
	public Integer registAccount(Account account) throws Exception;
	public List<UserFriendsView> getListFriends(String accountId) throws Exception;
	public boolean checkPhoneNo(String phoneNo) throws Exception;
	public UserFriendsView findFriends(String phoneNo) throws Exception;
	public int removeFriend(String accountId, String accountIdFriend) throws Exception;
	public List<LocationHistoryView> getLocationView(String accountId) throws Exception;
	public AccountInfo findAccountById(String id) throws Exception;
}
