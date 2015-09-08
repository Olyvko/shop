package com.olyvko.shop.service;

import java.util.List;

import com.olyvko.shop.entity.Product;


/**
 * Service interface. Declares business logic for ProductService beans.
 * 
 */
public interface ProductService {
	/**
	 * Creates new ProductService.
	 * 
	 */
	void create(Product product);

	/**
	 * Gets Product by id.
	 * 
	 * @param id
	 *            id for getting
	 * @return Product with specified id
	 */
	Product read(Long id);

	/**
	 * Gets all the Product.
	 * 
	 * @return list of Product
	 */
	List<Product> readAll();

	/**
	 * Updates existing Product.
	 * 
	 * @param product
	 *            Product instance to be updated
	 */
	void update(Product product);

	/**
	 * Delets Product by id.
	 * 
	 * @param id
	 *            id value for deleting
	 */
	void delete(Long id);

	/**
	 * Gets Product by String field.
	 * 
	 * @param key
	 *            field name.
	 * @param val
	 *            field value.
	 * @return Product instance if present or null
	 */
	Product readField(String key, String val);
	
	List<Product> readFieldByKey(String key, String val);
	
	List<Product> readFieldList(List<Long> id);
}

