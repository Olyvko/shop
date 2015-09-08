package com.olyvko.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olyvko.shop.dao.GenericDaoImpl;
import com.olyvko.shop.entity.ProductCategory;
import com.olyvko.shop.service.ProductCategoryService;

/**
 * Service class. Implements {@link ProductCategoryService} interface.
 * 
 * 
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	/**
	 * GenericDaoImpl<ProductCategory> instance for interaction with DAO layer.
	 */
	private GenericDaoImpl<ProductCategory> dao;

	/**
	 * Default constructor.
	 */
	public ProductCategoryServiceImpl() {
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param dao
	 *            GenericDaoImpl<ProductCategory> value for dao field
	 */
	@Autowired
	public ProductCategoryServiceImpl(GenericDaoImpl<ProductCategory> dao) {
		this.dao = dao;
		dao.setPersistentClass(ProductCategory.class);
	}

	@Override
	public void create(ProductCategory productCategory) {
		dao.add(productCategory);
	}

	@Override
	public ProductCategory read(Long id) {
		return dao.get(id);

	}

	@Override
	public List<ProductCategory> readAll() {
		return dao.getAll();
	}

	@Override
	public void update(ProductCategory productCategory) {
		dao.update(productCategory);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public ProductCategory readField(String key, String val) {
		return dao.getBySField(key, val);
	}
}


