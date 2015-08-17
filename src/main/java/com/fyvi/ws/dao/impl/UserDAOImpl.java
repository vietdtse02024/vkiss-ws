package com.fyvi.ws.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.dao.IUserDAO;

@SuppressWarnings("unchecked")
public class UserDAOImpl extends BaseHelperDAO<Account> implements IUserDAO<Account>{
	@Override
	public Account findByUuid(String uuid) {
		List<Account> listUser = getHibernateTemplate().find("from Account where uuid = ? and activeFlg = 1", uuid);
		if (listUser != null && listUser.size() > 0) {
			return listUser.get(0);
		}
		return null;
	}

	@Override
	public Integer registAccount(Account account) {
		getHibernateTemplate().save(account);
		return null;
	}

	@Override
	public List<Account> getListFriends(final String accountId) {
		final StringBuffer query = new StringBuffer("SELECT  ac.*					")
		.append(" FROM ACCOUNT AS ac INNER JOIN RELATION_SHIP AS rls				")
		.append(" ON ac.ACCOUNT_ID = rls.ACCOUNT_ID_FRIEND 							")
		.append(" WHERE rls.ACCOUNT_ID = :accountId 								");
		SQLQuery sqlQuery = getSession().createSQLQuery(query.toString()).addEntity(Account.class);
		sqlQuery.setString("accountId", accountId);
		return (List<Account>) sqlQuery.list();
	}

}
