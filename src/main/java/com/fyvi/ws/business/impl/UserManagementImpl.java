package com.fyvi.ws.business.impl;

import java.util.Date;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.business.IUserManagement;
import com.fyvi.ws.common.AbstractManager;
import com.fyvi.ws.common.DateUtils;
import com.fyvi.ws.common.IContants;
import com.fyvi.ws.common.MD5Encrypt;

public class UserManagementImpl extends AbstractManager implements IUserManagement{

	@Override
	public Account checkAccountExist(String uuid) {
		Account account = getUserDAO().findByPhoneNo(uuid);
		return account;
	}

	@Override
	public Integer registAccount(Account account) throws Exception {
		String accountId = "ACCOUNT_" + DateUtils.formatDateToString(new Date(), DateUtils.PATERN_YYYYMMDDhhmmss);
		String password = account.getPassword();
		account.setAccountId(accountId);
		account.setPassword(MD5Encrypt.crypt(password));
		account.setInputDate(new Date());
		account.setUpdateDate(new Date());
		account.setActiveFlg(IContants.ACTIVE_FLG.ACTIVE);
		return getUserDAO().registAccount(account);
	}

}
