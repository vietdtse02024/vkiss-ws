package com.fyvi.ws.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.bean.LocationHistory;
import com.fyvi.ws.common.QueryBuilderUtils;
import com.fyvi.ws.dao.IUserDAO;
import com.fyvi.ws.info.view.AccountInfo;

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
	public List<Account> getListFriends(String accountId) {
		StringBuffer query = new StringBuffer("SELECT  ac.*							")
		.append(" FROM ACCOUNT AS ac INNER JOIN RELATION_SHIP AS rls				")
		.append(" ON ac.ACCOUNT_ID = rls.ACCOUNT_ID_FRIEND 							")
		.append(" WHERE rls.ACCOUNT_ID = :accountId 								")
		.append(" AND rls.ACTIVE_FLG = 1 											")
		.append(" AND rls.STATUS = 1 												");
		SQLQuery sqlQuery = getSession().createSQLQuery(query.toString()).addEntity(Account.class);
		sqlQuery.setString("accountId", accountId);
		return (List<Account>) sqlQuery.list();
	}

	@Override
	public Account getUserByPhoneNo(String phoneNo) {
		Account account = null;
		List<Account> listUser = getHibernateTemplate().find("from Account where phoneNumber = ? and activeFlg = 1", phoneNo);
		if (listUser != null && listUser.size() > 0) {
			account = listUser.get(0);
		}
		return account;
	}

	@Override
	public int removeFriend(String accountId, String accountIdFriend) {
		StringBuffer query = new StringBuffer("UPDATE RELATION_SHIP ")
			.append(" SET ACTIVE_FLG = 0 											")
			.append(" WHERE (	ACCOUNT_ID 					= :accountId			")
			.append(" 			AND ACCOUNT_ID_FRIEND 		= :accountIdFriend)		")
			.append(" 	OR 	(	ACCOUNT_ID 					= :accountIdFriend2		")
			.append(" 			AND ACCOUNT_ID_FRIEND 		= :accountId2)			");
		
		SQLQuery sqlQuery = getSession().createSQLQuery(query.toString());
		sqlQuery.setString("accountId", accountId);
		sqlQuery.setString("accountIdFriend", accountIdFriend);
		sqlQuery.setString("accountId2", accountIdFriend);
		sqlQuery.setString("accountIdFriend2", accountId);
		return sqlQuery.executeUpdate();
		
	}

	@Override
	public List<LocationHistory> getLocation(String accountId) throws Exception {
		StringBuffer query = new StringBuffer("SELECT *						")
		.append(" FROM LOCATION_HISTORY 									")
		.append(" WHERE ACCOUNT_ID = :accountId 							")
		.append(" AND ACTIVE_FLG = 1 										")
		.append(" ORDER BY UPDATED_DATE DESC 								");
		SQLQuery sqlQuery = getSession().createSQLQuery(query.toString()).addEntity(LocationHistory.class);
		sqlQuery.setString("accountId", accountId);
		return (List<LocationHistory>) sqlQuery.list();
	}

	@Override
	public List<AccountInfo> getAccountInfo(final String accountId) throws Exception {
		final StringBuffer sqlQuery = new StringBuffer("SELECT account.ACCOUNT_ID AS accountId,		")
		.append(" account.ACCOUNT_NAME  AS accountName,										")
		.append(" account.FULL_NAME AS fullName, 											")
		.append(" location.UPDATED_DATE AS lastUpdateLocation 								")
		.append(" FROM ACCOUNT account 	INNER JOIN LOCATION_HISTORY location				")
		.append(" ON 	account.ACCOUNT_ID = location.ACCOUNT_ID							")
		.append(" WHERE account.ACCOUNT_ID = :accountId 									")
		.append(" AND account.ACTIVE_FLG = 1 AND location.ACTIVE_FLG 						")
		.append(" ORDER BY location.UPDATED_DATE DESC 										");
		Query query = QueryBuilderUtils.getSQLQuery(getSession(), sqlQuery.toString(), AccountInfo.class );
		query.setParameter("accountId", accountId);
		return (List<AccountInfo>) query.list();
	}

}
