package com.fyvi.ws.common;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 * CrBy vKiss
 * Gets the SQL query.
 *
 * @param em the em
 * @param queryString the query string
 * @param mapParameter the map parameter
 * @param entity the entity
 * @return the SQL query
 */
public class QueryBuilderUtils {
	
	/**
	 * CrBy vKiss
	 * Gets the SQL query.
	 *
	 * @param em the em
	 * @param queryString the query string
	 * @param mapParameter the map parameter
	 * @return the SQL query
	 */
	public static Query getSQLQuery(Session em, String queryString, Map<String, Object> mapParameter) {
		return getSQLQuery(em, queryString, mapParameter, null);
	}
	
	public static Query getSQLQuery(Session em, String queryString, Class<?> entity) {
		return getSQLQuery(em, queryString, null,entity);
	}
	
	public static Query getSQLQuery(Session em, String queryString, Map<String, Object> mapParameter, Class<?> entity) {
		SQLQuery sqlQuery = em.createSQLQuery(queryString);
		if(!isNativeDataType(entity) && entity != null){
			Field[] fieldEntity = entity.getDeclaredFields();
			if(fieldEntity != null && fieldEntity.length > 0) {
				for(Field propertyItem : fieldEntity) {				
					if(propertyItem.getType().equals(String.class)) {
						sqlQuery.addScalar(propertyItem.getName(), Hibernate.STRING) ;
					} else if(propertyItem.getType().equals(BigDecimal.class)) {
						sqlQuery.addScalar(propertyItem.getName(), Hibernate.BIG_DECIMAL) ;
					} else if(propertyItem.getType().equals(Integer.class)) {
						sqlQuery.addScalar(propertyItem.getName(), Hibernate.INTEGER) ;
					} else if(propertyItem.getType().equals(Timestamp.class)) {
						sqlQuery.addScalar(propertyItem.getName(), Hibernate.TIMESTAMP) ;
					} else if(propertyItem.getType().equals(Double.class)) {
						sqlQuery.addScalar(propertyItem.getName(), Hibernate.DOUBLE) ;						
					} else if(propertyItem.getType().equals(Boolean.class)) {
						sqlQuery.addScalar(propertyItem.getName(), Hibernate.BOOLEAN) ;						
					}
					else if(propertyItem.getType().equals(Long.class)) {
						sqlQuery.addScalar(propertyItem.getName(), Hibernate.LONG) ;						
					}
				}
			}
			sqlQuery.setResultTransformer(Transformers.aliasToBean(entity));
		}
		setParamToQuery(sqlQuery, mapParameter);
		return sqlQuery;
	}
	
	/**
	 * CrBy vKiss
	 * Checks if is native data type.
	 *
	 * @param entity the entity
	 * @return true, if is native data type
	 */
	private static boolean isNativeDataType(Class<?> entity){
		if(entity == String.class || entity == BigDecimal.class || 
			entity == Integer.class || entity == Timestamp.class ){
			return true;
		}
		return false;
	}
	
	/**
	 * CrBy vKiss
	 * Sets the param to query.
	 *
	 * @param query the query
	 * @param mapParameter the map parameter
	 */
	public static void  setParamToQuery(Query query, Map<String, Object> mapParameter ){
		if(mapParameter != null){
			for (String key : mapParameter.keySet()) {
				if (mapParameter.get(key) instanceof Collection) {
					query.setParameterList(key, (Collection<?>) mapParameter.get(key));
				} else {
					query.setParameter(key, mapParameter.get(key));
				}
			}
		}
	}
}
