package com.fyvi.ws.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;

import com.fyvi.ws.bean.RelationShip;
import com.fyvi.ws.dao.IRelationShipDAO;

public class RelationShipDAOImpl extends BaseHelperDAO<RelationShip> implements IRelationShipDAO<RelationShip>{
	
	@Override
	public int addFriend(String accountId, String accountIdFriend) {
		StringBuffer query = new StringBuffer("INSERT INTO RELATION_SHIP ")
		.append(" (ACCOUNT_ID, ACCOUNT_ID_FRIEND, STATUS, INPUT_DATE, UPDATED_DATE, ACTIVE_FLG)		")
		.append(" VALUES (:accountId, :accountIdFriend, 0, now(), now(), 1)								");
		SQLQuery sqlQuery = getSession().createSQLQuery(query.toString());
		sqlQuery.setString("accountId", accountId);
		sqlQuery.setString("accountIdFriend", accountIdFriend);
		return sqlQuery.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public RelationShip isFriend(String accountId, String accountIdFriend) {
		RelationShip result = null;
		List<RelationShip> listResult = getHibernateTemplate().find("from RelationShip where (accountId = ? and accountIdFriend = ?) or (accountId = ? and accountIdFriend = ?)",
				accountId, accountIdFriend, accountIdFriend, accountId);
		if (listResult != null && listResult.size() > 0) {
			result = listResult.get(0);
		}
		return result;
	}

	@Override
	public int updateFriend(String accountId, String accountIdFriend, Integer activeFlg, Integer status) {
		StringBuffer query = new StringBuffer("UPDATE RELATION_SHIP 			")
		.append(" SET ACTIVE_FLG = :activeFlg, STATUS = :status, 				")
		.append(" UPDATED_DATE = now() 											")
		.append(" WHERE (	ACCOUNT_ID 					= :accountId			")
		.append(" 			AND ACCOUNT_ID_FRIEND 		= :accountIdFriend)		")
		.append(" 	OR 	(	ACCOUNT_ID 					= :accountIdFriend		")
		.append(" 			AND ACCOUNT_ID_FRIEND 		= :accountId)			");
	
		SQLQuery sqlQuery = getSession().createSQLQuery(query.toString());
		sqlQuery.setInteger("activeFlg", activeFlg);
		sqlQuery.setInteger("status", status);
		sqlQuery.setString("accountId", accountId);
		sqlQuery.setString("accountIdFriend", accountIdFriend);
		return sqlQuery.executeUpdate();
	}
}
