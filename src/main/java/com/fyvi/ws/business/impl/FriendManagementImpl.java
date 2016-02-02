package com.fyvi.ws.business.impl;

import com.fyvi.ws.business.IFriendManagement;
import com.fyvi.ws.common.AbstractManager;
import com.fyvi.ws.common.IContants;

public class FriendManagementImpl extends AbstractManager implements IFriendManagement{
	@Override
	public void addNewFriend(String accountId, String accountFriendId) throws Exception {
		getRelationShipDAO().addFriend(accountId, accountFriendId);
		
	}

	@Override
	public void requestFriend(String accountId, String accountFriendId) throws Exception {
		getRelationShipDAO().updateFriend(accountId, accountFriendId, IContants.ACTIVE_FLG.ACTIVE, IContants.STATUS.FRIEND_REQUESTING);
	}
}
