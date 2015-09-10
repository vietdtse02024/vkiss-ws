package com.fyvi.ws.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.fyvi.ws.bean.LocationHistory;
import com.fyvi.ws.common.QueryBuilderUtils;
import com.fyvi.ws.dao.ILocationHisDAO;
import com.fyvi.ws.info.view.LocationHistoryView;

public class LocationHisDAOImpl extends BaseHelperDAO<LocationHistory> implements ILocationHisDAO<LocationHistory>{

	@SuppressWarnings("unchecked")
	@Override
	public List<LocationHistoryView> getListLocationHis(String accountId) throws Exception {
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("SELECT lh.ADDRESS AS address,					")
		.append(" lh.LATITUDE AS latitude,							")
		.append(" lh.LONGTITUDE AS longtitude,						")
		.append(" lh.UPDATED_DATE AS updateDate,					")
		.append(" ac.FULL_NAME AS fullName,							")
		.append(" ac.ACCOUNT_ID AS accountId,						")
		.append(" ac.PHONE_NUMBER AS phoneNumber					")
		.append(" FROM LOCATION_HISTORY lh							")
		.append(" INNER JOIN ACCOUNT ac								")
		.append(" ON lh.ACCOUNT_ID = ac.ACCOUNT_ID					")
		.append(" WHERE lh.ACCOUNT_ID = :accountId 					")
		.append(" AND lh.ACTIVE_FLG = 1 							")
		.append(" AND ac.ACTIVE_FLG = 1 							")
		.append(" ORDER BY lh.UPDATED_DATE DESC 					");
		
		Query query = QueryBuilderUtils.getSQLQuery(getSession(), sqlQuery.toString(), LocationHistoryView.class );
//		SQLQuery sqlQuery = getSession().createSQLQuery(query.toString()).addEntity(LocationHistoryView.class);
		query.setParameter("accountId", accountId);
		return (List<LocationHistoryView>) query.list();
	}

}
