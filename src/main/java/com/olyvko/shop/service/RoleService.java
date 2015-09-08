package com.olyvko.shop.service;

import java.util.List;

import com.olyvko.shop.entity.Product;
import com.olyvko.shop.entity.Role;


/**
 * Service interface. Declares business logic for RoleService beans.
 * 
 */
public interface RoleService {
	/**
	 * Creates new RoleService.
	 * 
	 * @param Role
	 *            Role instance for adding
	 */
	void create(Role role);

	/**
	 * Gets Role by id.
	 * 
	 * @param id
	 *            id for getting
	 * @return Role with specified id
	 */
	Role read(Long id);

	/**
	 * Gets all the Role.
	 * 
	 * @return list of Role
	 */
	List<Role> readAll();

	/**
	 * Updates existing Role.
	 * 
	 * @param Role
	 *            Role instance to be updated
	 */
	void update(Role role);


	/**
	 * Delets Role by id.
	 * 
	 * @param id
	 *            id value for deleting
	 */
	void delete(Long id);

	/**
	 * Gets Role by String field.
	 * 
	 * @param key
	 *            field name.
	 * @param val
	 *            field value.
	 * @return Role instance if present or null
	 */
	Role readField(String key, String val);

	List<Role> readFieldByKey(String key, String val);
	
	List<Role> readFieldList(List<Long> id);
}

