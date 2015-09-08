package com.olyvko.shop.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olyvko.shop.dao.GenericDao;
import com.olyvko.shop.dao.GenericDaoImpl;
import com.olyvko.shop.entity.User;
import com.olyvko.shop.entity.Role;
import com.olyvko.shop.service.impl.RoleServiceImpl;
import com.olyvko.shop.service.UserService;

/**
 * Service class. Implements {@link UserService} interface.
 * 
 * 
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
	/**
	 * GenericDaoImpl<User> instance for interaction with DAO layer.
	 */
	private GenericDao<User> dao;

	/**
	 * A standard PasswordEncoder implementation that uses SHA-256 hashing with
	 * 1024 iterations and a random 8-byte random salt value.
	 */
	@Autowired
	private StandardPasswordEncoder encoder;
	/**
	 * Default constructor.
	 */

	/**
	 * RoleService instance for Role beans.
	 */
	@Autowired
	private RoleServiceImpl roleService;
	
	public UserServiceImpl() {
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param dao
	 *            GenericDaoImpl<User> value for dao field
	 */
	@Autowired
	public UserServiceImpl(GenericDao<User> dao) {
		this.dao = dao;
		dao.setPersistentClass(User.class);
	}
	
	
	@Override
	public void create(User user) {
		
		String plainPasswd = user.getPassword();
		String hashedPasswd = encoder.encode(plainPasswd);
		user.setPassword(hashedPasswd);
		user.setActive(true);
		if (user.getRoles().isEmpty()) {
			Set<Role> roles = new HashSet<Role>();
			roles.add(roleService.readField("NAME", "ROLE_USER"));
			user.setRoles(roles);
		}
		
		dao.add(user);
	}

	@Override
	public User read(Long id) {
		return dao.get(id);

	}

	@Override
	public List<User> readAll() {
		return dao.getAll();
	}

	@Override
	public void update(User user) {
		dao.update(user);
	}

	
	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public User readField(String key, String val) {
		return dao.getBySField(key, val);
	}

	@Override
	public List<User> readFieldByKey(String key, String val) {
		return dao.getBySFieldByKey(key, val);
	}
	@Override
	public List<User> readFieldList(List<Long> id) {
		return dao.getListByIN(id);
	}
}


