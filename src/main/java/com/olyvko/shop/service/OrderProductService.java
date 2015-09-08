package com.olyvko.shop.service;

import java.util.List;

import com.olyvko.shop.entity.OrderProduct;

public interface OrderProductService {
	/**
	 * Creates new OrderProductProduct.
	 * 
	 * @param OrderProduct
	 *            OrderProduct instance for adding
	 */
	void create(OrderProduct orderProduct);

	/**
	 * Gets OrderProduct by id.
	 * 
	 * @param id
	 *            id for getting
	 * @return OrderProduct with specified id
	 */
	OrderProduct read(Long id);

	/**
	 * Gets all the OrderProduct.
	 * 
	 * @return list of OrderProduct
	 */
	List<OrderProduct> readAll();

	/**
	 * Updates existing OrderProduct.
	 * 
	 * @param OrderProduct
	 *            OrderProduct instance to be updated
	 */
	void update(OrderProduct orderProduct);

	/**
	 * Delets OrderProduct by it's OrderProduct instance.
	 * 
	 * @param OrderProduct
	 *            OrderProduct instance for deleting
	 */
	
	void delete(Long id);

	/**
	 * Gets OrderProduct by String field.
	 * 
	 * @param key
	 *            field name.
	 * @param val
	 *            field value.
	 * @return OrderProduct instance if present or null
	 */
	OrderProduct readField(String key, String val);
	
	List<OrderProduct> readFieldByKey(String key, String val);
	
	List<OrderProduct> readFieldList(List<Long> id);
}
