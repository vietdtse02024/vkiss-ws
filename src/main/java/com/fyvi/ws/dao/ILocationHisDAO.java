package com.fyvi.ws.dao;

import java.util.List;

import com.fyvi.ws.info.view.LocationHistoryView;

public interface ILocationHisDAO<E> extends IBaseDAO<E> {
	public List<LocationHistoryView> getListLocationHis(String accountId) throws Exception;
}
