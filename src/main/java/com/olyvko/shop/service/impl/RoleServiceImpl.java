package com.olyvko.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olyvko.shop.dao.GenericDaoImpl;
import com.olyvko.shop.entity.Role;
import com.olyvko.shop.service.RoleService;

/**
 * Service class. Implements {@link RoleService} interface.
 * 
 * 
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	/**
	 * GenericDaoImpl<Role> instance for interaction with DAO layer.
	 */
	private GenericDaoImpl<Role> dao;

	/**
	 * Default constructor.
	 */
	public RoleServiceImpl() {
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param dao
	 *            GenericDaoImpl<Role> value for dao field
	 */
	@Autowired
	public RoleServiceImpl(GenericDaoImpl<Role> dao) {
		this.dao = dao;
		dao.setPersistentClass(Role.class);
	}

	@Override
	public void create(Role Role) {
		dao.add(Role);
	}

	@Override
	public Role read(Long id) {
		return dao.get(id);

	}

	@Override
	public List<Role> readAll() {
		return dao.getAll();
	}

	@Override
	public void update(Role role) {
		dao.update(role);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public Role readField(String key, String val) {
		return dao.getBySField(key, val);
	}

	@Override
	public List<Role> readFieldByKey(String key, String val) {
		return dao.getBySFieldByKey(key, val);
	}
	@Override
	public List<Role> readFieldList(List<Long> id) {
		return dao.getListByIN(id);
	}
}

