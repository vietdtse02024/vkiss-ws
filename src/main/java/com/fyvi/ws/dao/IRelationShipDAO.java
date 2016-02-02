package com.fyvi.ws.dao;

import com.fyvi.ws.bean.RelationShip;


public interface IRelationShipDAO<E> extends IBaseDAO<E> {
	public int addFriend(String accountId, String accountIdFriend);
	public int updateFriend(String accountId, String accountIdFriend, Integer activeFlg, Integer status);
	public RelationShip isFriend(String accountId, String accountIdFriend);
}
