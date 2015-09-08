package com.olyvko.shop.service;

import java.util.List;

import com.olyvko.shop.entity.ProductCategory;


/**
 * Service interface. Declares business logic for ProductCategory beans.
 * 
 */
public interface ProductCategoryService {
	/**
	 * Creates new ProductCategory.
	 * 
	 * @param productCategory
	 *            ProductCategory instance for adding
	 */
	void create(ProductCategory productCategory);

	/**
	 * Gets ProductCategory by id.
	 * 
	 * @param id
	 *            id for getting
	 * @return ProductCategory with specified id
	 */
	ProductCategory read(Long id);

	/**
	 * Gets all the ProductCategorys.
	 * 
	 * @return list of ProductCategorys
	 */
	List<ProductCategory> readAll();

	/**
	 * Updates existing ProductCategory.
	 * 
	 * @param ProductCategory
	 *            ProductCategory instance to be updated
	 */
	void update(ProductCategory productCategory);


	/**
	 * Delets ProductCategory by id.
	 * 
	 * @param id
	 *            id value for deleting
	 */
	void delete(Long id);

	/**
	 * Gets ProductCategory by String field.
	 * 
	 * @param key
	 *            field name.
	 * @param val
	 *            field value.
	 * @return ProductCategory instance if present or null
	 */
	ProductCategory readField(String key, String val);
}

