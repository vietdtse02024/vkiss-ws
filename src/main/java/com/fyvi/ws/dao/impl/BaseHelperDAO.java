package com.fyvi.ws.dao.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fyvi.ws.dao.IBaseDAO;

public class BaseHelperDAO<E> extends HibernateDaoSupport implements IBaseDAO<E>{
	private static final Logger log = Logger.getLogger(BaseHelperDAO.class);
	@Override
	public E findById(Class<E> e, Serializable id) {
		log.debug(new StringBuffer("getting ").append(e.getName()).append(" instance with id: ").append(id));
		try {
            if(id == null) return null;
			E instance = getHibernateTemplate().get(e, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
}
