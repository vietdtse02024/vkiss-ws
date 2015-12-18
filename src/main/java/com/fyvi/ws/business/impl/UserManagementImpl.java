package com.fyvi.ws.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.business.IUserManagement;
import com.fyvi.ws.common.AbstractManager;
import com.fyvi.ws.common.DateUtils;
import com.fyvi.ws.common.IContants;
import com.fyvi.ws.common.MD5Encrypt;
import com.fyvi.ws.info.view.AccountInfo;
import com.fyvi.ws.info.view.LocationHistoryView;
import com.fyvi.ws.info.view.UserFriendsView;

public class UserManagementImpl extends AbstractManager implements IUserManagement{

	@Override
	public Account checkAccountExist(String uuid) {
		Account account = getUserDAO().findByUuid(uuid);
		return account;
	}

	@Override
	public Integer registAccount(Account account) throws Exception {
		Date currentDate = new Date();
		String accountId = "ACCOUNT_" + DateUtils.formatDateToString(currentDate, DateUtils.PATERN_YYYYMMddhhmmss);
		String password = account.getPassword();
		account.setAccountId(accountId);
		account.setPassword(MD5Encrypt.crypt(password));
		account.setInputDate(currentDate);
		account.setUpdateDate(currentDate);
		account.setActiveFlg(IContants.ACTIVE_FLG.ACTIVE);
		return getUserDAO().registAccount(account);
	}

	@Override
	public List<UserFriendsView> getListFriends(String accountId) throws Exception {
		List<Account> listAccount = getUserDAO().getListFriends(accountId);
		List<UserFriendsView> listFriends = new ArrayList<UserFriendsView>();
		for (Account account : listAccount) {
			UserFriendsView entity = new UserFriendsView();
			BeanUtils.copyProperties(account, entity);
			listFriends.add(entity);
		}
		return listFriends;
	}

	@Override
	public boolean checkPhoneNo(String phoneNo) throws Exception {
		Account account = getUserDAO().getUserByPhoneNo(phoneNo);
		return account == null ? false : true;
	}

	@Override
	public int removeFriend(String accountId, String accountIdFriend) throws Exception {
		return getUserDAO().removeFriend(accountId, accountIdFriend);
	}

	@Override
	public UserFriendsView findFriends(String phoneNo) throws Exception {
		Account account = getUserDAO().getUserByPhoneNo(phoneNo);
		UserFriendsView userFriendsView = null;
		if (account != null) {
			userFriendsView = new UserFriendsView();
			BeanUtils.copyProperties(account, userFriendsView);
		}
		return userFriendsView;
	}

	@Override
	public List<LocationHistoryView> getLocationView(String accountId) throws Exception {
		return getLocationHisDAO().getListLocationHis(accountId);
	}

	@Override
	public AccountInfo findAccountById(String id) throws Exception {
		List<AccountInfo> resultDAO = getUserDAO().getAccountInfo(id);
		if (resultDAO != null && resultDAO.size() > 0) {
			return resultDAO.get(0);
		}
		return null;
	}

}
