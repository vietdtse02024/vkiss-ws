package com.fyvi.ws.common;

import com.fyvi.ws.bean.Account;
import com.fyvi.ws.bean.RelationShip;
import com.fyvi.ws.dao.ILocationHisDAO;
import com.fyvi.ws.dao.IRelationShipDAO;
import com.fyvi.ws.dao.IUserDAO;

public class AbstractManager {
	IUserDAO<Account> userDAO;
	ILocationHisDAO<Account> locationHisDAO;
	IRelationShipDAO<RelationShip> relationShipDAO;

	public IUserDAO<Account> getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO<Account> userDAO) {
		this.userDAO = userDAO;
	}

	public ILocationHisDAO<Account> getLocationHisDAO() {
		return locationHisDAO;
	}

	public void setLocationHisDAO(ILocationHisDAO<Account> locationHisDAO) {
		this.locationHisDAO = locationHisDAO;
	}

	public IRelationShipDAO<RelationShip> getRelationShipDAO() {
		return relationShipDAO;
	}

	public void setRelationShipDAO(IRelationShipDAO<RelationShip> relationShipDAO) {
		this.relationShipDAO = relationShipDAO;
	}
	
	public RelationShip getRelationShip(String accountId, String accountFriendId) throws Exception {
		RelationShip resultDAO = getRelationShipDAO().isFriend(accountId, accountFriendId);
		return resultDAO;
	}
}
