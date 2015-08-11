package com.fyvi.ws.business.impl;

import java.util.Date;
import java.util.List;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.bean.User;
import com.fyvi.ws.business.IUserManagement;
import com.fyvi.ws.common.AbstractManager;
import com.fyvi.ws.common.DateUtils;
import com.fyvi.ws.common.IContants;

public class UserManagementImpl extends AbstractManager implements IUserManagement{

	@Override
	public List<User> getListUser() {
		List<User> listUser = getUserDAO().getListUser();
		return listUser;
	}

	@Override
	public Account checkAccountExist(String phoneNo) {
		Account account = getUserDAO().findByPhoneNo(phoneNo);
		return account;
	}

	@Override
	public Integer registAccount(Account account) throws Exception {
		String accountId = "ACCOUNT_" + DateUtils.formatDateToString(new Date(), DateUtils.PATERN_YYYYMMDDhhmmss);
		account.setAccountId(accountId);
		account.setInputDate(new Date());
		account.setUpdateDate(new Date());
		account.setActiveFlg(IContants.ACTIVE_FLG.ACTIVE);
		return getUserDAO().registAccount(account);
	}

}
