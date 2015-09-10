package com.fyvi.ws.dao;

import java.io.Serializable;

public interface IBaseDAO<E> {
	public E findById(Class<E> e, Serializable id);
}
