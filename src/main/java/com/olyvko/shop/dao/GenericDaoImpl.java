package com.olyvko.shop.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements IGenericDao interface.
 * 
 * 
 * @param <T>
 *            generic type for implementing classes
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transactional
public class GenericDaoImpl<T> implements GenericDao<T> {

	/**
	 * Class<T> instance.
	 */
	private Class<T> clazz;

	/**
	 * EntityManager instance for interaction with database.
	 */
	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(T object) {
		em.persist(object);
	}

	@Override
	public void update(T object) {
		em.merge(object);

	}

	@Override
	public T get(Long id) {
		return em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	@Override
	public T getBySField(String key, String val) {
		@SuppressWarnings("unchecked")
		List<T> tl = em.createQuery(
				"from " + clazz.getName() + " where " + key + "=\'" + val
						+ "\'").getResultList();
		if (tl != null && tl.size() > 0) {
			return tl.get(0);
		}
		return null;
	}

	@Override
	public List<T> getBySFieldByKey(String key, String val) {
		@SuppressWarnings("unchecked")
		List<T> tl = em.createQuery(
				"from " + clazz.getName() + " where " + key + "=\'" + val
						+ "\'").getResultList();
		if (tl != null && tl.size() > 0) {
			return tl;
		}
		return null;
	}
	
	@Override
	public void delete(Long id) {
		T t = get(id);
		
		System.out.println("PPPPPP"  + t.toString());
		em.remove(t);
	}

	@Override
	public Class<T> getPersistentClass() {
		return this.clazz;
	}

	@Override
	public void setPersistentClass(Class<T> clazz) {
		this.clazz = clazz;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getListByIN(List<Long> id) {
		Query query = em.createQuery("Select obj from " + clazz.getName()
				+ " obj where obj.id IN :id");
		query.setParameter("id", id);
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> executeQuery(String query) {
		Query querry = em.createQuery(query);
		if (!querry.getResultList().isEmpty())
			return querry.getResultList();
		else
			return null;
	}
}

