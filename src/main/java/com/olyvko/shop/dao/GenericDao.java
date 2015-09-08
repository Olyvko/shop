package com.olyvko.shop.dao;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Interface for Dao implementation.
 * @param <T> generic type for implementing classes
 * 
 */
public interface GenericDao<T> {

	/**
	 * Inserts new row into DB table.
	 * 
	 * @param object
	 *            T instance for adding
	 */
	void add(T object);

	/**
	 * Updates existing row in DB table.
	 * 
	 * @param object
	 *            T instance for updating
	 */
	void update(T object);

	/**
	 * Selects row from DB table by id.
	 * 
	 * @param id
	 *            id value for getting
	 * 
	 * @return T instance
	 */
	T get(Long id);

	/**
	 * Selects all the raws from DB table.
	 * 
	 * @return list of T instances.
	 */
	List<T> getAll();

	/**
	 * Gets user by String field.
	 * 
	 * @param key
	 *            field name.
	 * @param val
	 *            field value.
	 * @return User instance if present or null
	 */
	T getBySField(String key, String val);
	
	List<T> getBySFieldByKey(String key, String val);

	/**
	 * Deletes existing row in DB table by T instance.
	 * 
	 * @param object
	 *            T instance for deleting
	 */
	void delete(Long id);

	/**
	 * Gets class value.
	 * 
	 * @return Class<T> instance
	 */
	Class<T> getPersistentClass();

	/**
	 * Sets class.
	 * 
	 * @param clazz
	 *            Class<T> instance
	 */
	void setPersistentClass(Class<T> clazz);
	
	
	
	/**
	 * Gets the list by in.
	 *
	 * @param id the id
	 * @return the list by in
	 */
	List<T> getListByIN(List<Long> id);
	
	/**
	 * Execute query.
	 *
	 * @param query the query
	 * @return the t
	 */
	 List<T> executeQuery(String query);

}

