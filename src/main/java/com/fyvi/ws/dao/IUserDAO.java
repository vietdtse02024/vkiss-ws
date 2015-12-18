package com.fyvi.ws.dao;

import java.util.List;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.bean.LocationHistory;
import com.fyvi.ws.info.view.AccountInfo;

public interface IUserDAO<E> extends IBaseDAO<E> {
	public Account findByUuid(String uuid);
	public Integer registAccount(Account account);
	public List<Account> getListFriends(String accountId);
	public Account getUserByPhoneNo(String phoneNo);
	public int removeFriend(String accountId, String accountIdFriend);
	public List<LocationHistory> getLocation(String accountId) throws Exception;
	public List<AccountInfo> getAccountInfo(String accountId) throws Exception;
}
