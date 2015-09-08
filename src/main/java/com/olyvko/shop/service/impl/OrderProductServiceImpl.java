package com.olyvko.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olyvko.shop.dao.GenericDao;
import com.olyvko.shop.entity.OrderProduct;
import com.olyvko.shop.service.OrderProductService;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {
	/**
	 * GenericDaoImpl<OrderProduct> instance for interaction with DAO layer.
	 */
	private GenericDao<OrderProduct> dao;

	/**
	 * Default constructor.
	 */
	public OrderProductServiceImpl() {
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param dao
	 *            GenericDaoImpl<OrderProduct> value for dao field
	 */
	@Autowired
	public OrderProductServiceImpl(GenericDao<OrderProduct> dao) {
		this.dao = dao;
		dao.setPersistentClass(OrderProduct.class);
	}
	
	
	@Override
	public void create(OrderProduct orderProduct) {
		dao.add(orderProduct);
	}

	@Override
	public OrderProduct read(Long id) {
		return dao.get(id);

	}

	@Override
	public List<OrderProduct> readAll() {
		return dao.getAll();
	}

	@Override
	public void update(OrderProduct orderProduct) {
		dao.update(orderProduct);
	}

	
	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public OrderProduct readField(String key, String val) {
		return dao.getBySField(key, val);
	}

	@Override
	public List<OrderProduct> readFieldByKey(String key, String val) {
		return dao.getBySFieldByKey(key, val);
	}
	@Override
	public List<OrderProduct> readFieldList(List<Long> id) {
		return dao.getListByIN(id);
	}
}
