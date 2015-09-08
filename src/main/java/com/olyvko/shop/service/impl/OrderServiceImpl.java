package com.olyvko.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olyvko.shop.dao.GenericDao;
import com.olyvko.shop.entity.Order;
import com.olyvko.shop.entity.Order;
import com.olyvko.shop.service.OrderService;
import com.olyvko.shop.service.OrderService;

/**
 * Service class. Implements {@link OrderServiceImpl} interface.
 * 
 * 
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	/**
	 * GenericDaoImpl<Order> instance for interaction with DAO layer.
	 */
	private GenericDao<Order> dao;

	/**
	 * Default constructor.
	 */
	public OrderServiceImpl() {
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param dao
	 *            GenericDaoImpl<Order> value for dao field
	 */
	@Autowired
	public OrderServiceImpl(GenericDao<Order> dao) {
		this.dao = dao;
		dao.setPersistentClass(Order.class);
	}
	
	
	@Override
	public void create(Order order) {
		dao.add(order);
	}

	@Override
	public Order read(Long id) {
		return dao.get(id);

	}

	@Override
	public List<Order> readAll() {
		return dao.getAll();
	}

	@Override
	public void update(Order order) {
		dao.update(order);
	}

	
	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public Order readField(String key, String val) {
		return dao.getBySField(key, val);
	}

	@Override
	public List<Order> readFieldByKey(String key, String val) {
		return dao.getBySFieldByKey(key, val);
	}
	@Override
	public List<Order> readFieldList(List<Long> id) {
		return dao.getListByIN(id);
	}
}
