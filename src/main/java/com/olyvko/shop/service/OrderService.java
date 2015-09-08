package com.olyvko.shop.service;


import java.util.List;

import com.olyvko.shop.entity.Order;

public interface OrderService {
	/**
	 * Creates new OrderService.
	 * 
	 * @param OrderCategory
	 *            OrderCategory instance for adding
	 */
	void create(Order order);

	/**
	 * Gets OrderCategory by id.
	 * 
	 * @param id
	 *            id for getting
	 * @return Order with specified id
	 */
	Order read(Long id);

	/**
	 * Gets all the Order.
	 * 
	 * @return list of Order
	 */
	List<Order> readAll();

	/**
	 * Updates existing OrderCategory.
	 * 
	 * @param Order
	 *            Order instance to be updated
	 */
	void update(Order order);

	/**
	 * Delets Order by it's Order instance.
	 * 
	 * @param Order
	 *            Order instance for deleting
	 */
	
	void delete(Long id);

	/**
	 * Gets Order by String field.
	 * 
	 * @param key
	 *            field name.
	 * @param val
	 *            field value.
	 * @return Order instance if present or null
	 */
	Order readField(String key, String val);
	
	List<Order> readFieldByKey(String key, String val);
	
	List<Order> readFieldList(List<Long> id);
}

