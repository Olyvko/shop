package com.olyvko.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olyvko.shop.dao.GenericDaoImpl;
import com.olyvko.shop.entity.Product;
import com.olyvko.shop.entity.ProductCategory;
import com.olyvko.shop.service.ProductService;

/**
 * Service class. Implements {@link ProductService} interface.
 * 
 * 
 */
@Service
//@Transactional
public class ProductServiceImpl implements ProductService{
	/**
	 * GenericDaoImpl<Product> instance for interaction with DAO layer.
	 */
	private GenericDaoImpl<Product> dao;
	
	@Autowired
	ProductCategoryServiceImpl pcs;

	/**
	 * Default constructor.
	 */
	public ProductServiceImpl() {
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param dao
	 *            GenericDaoImpl<Product> value for dao field
	 */
	@Autowired
	public ProductServiceImpl(GenericDaoImpl<Product> dao, GenericDaoImpl<ProductCategory> catDao) {
		this.dao = dao;
		dao.setPersistentClass(Product.class);
	}

	@Override
	public void create(Product product) {
		dao.add(product);
	}

	@Override
	public Product read(Long id) {
		return dao.get(id);

	}

	@Override
	public List<Product> readAll() {
		return dao.getAll();
	}

	@Override
	public void update(Product product) {
		dao.update(product);
	}

	

	@Override
	public void delete(Long id) {
		Product product = read(id);
		product.setProductCategory(null);
		update(product);
		dao.delete(id);
	}

	@Override
	public Product readField(String key, String val) {
		return dao.getBySField(key, val);
	}

	@Override
	public List<Product> readFieldByKey(String key, String val) {
		return dao.getBySFieldByKey(key, val);
	}
	@Override
	public List<Product> readFieldList(List<Long> id) {
		return dao.getListByIN(id);
	}
}

