package com.fyvi.ws.business;

import com.fyvi.ws.bean.RelationShip;


public interface IFriendManagement {
	public void addNewFriend(String accountId, String accountFriendId) throws Exception;
	public void requestFriend(String accountId, String accountFriendId) throws Exception;
	public RelationShip getRelationShip(String accountId, String accountFriendId) throws Exception;
}
