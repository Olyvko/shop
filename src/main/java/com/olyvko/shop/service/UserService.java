package com.olyvko.shop.service;

import java.util.List;

import com.olyvko.shop.entity.Product;
import com.olyvko.shop.entity.User;


/**
 * Service interface. Declares business logic for UserService beans.
 * 
 */
public interface UserService {
	/**
	 * Creates new UserService.
	 * 
	 * @param User
	 *            User instance for adding
	 */
	void create(User User);

	/**
	 * Gets User by id.
	 * 
	 * @param id
	 *            id for getting
	 * @return User with specified id
	 */
	User read(Long id);

	/**
	 * Gets all the User.
	 * 
	 * @return list of User
	 */
	List<User> readAll();

	/**
	 * Updates existing User.
	 * 
	 * @param User
	 *            User instance to be updated
	 */
	void update(User User);


	/**
	 * Delets User by id.
	 * 
	 * @param id
	 *            id value for deleting
	 */
	void delete(Long id);

	/**
	 * Gets User by String field.
	 * 
	 * @param key
	 *            field name.
	 * @param val
	 *            field value.
	 * @return User instance if present or null
	 */
	User readField(String key, String val);

	List<User> readFieldByKey(String key, String val);
	
	List<User> readFieldList(List<Long> id);
}

