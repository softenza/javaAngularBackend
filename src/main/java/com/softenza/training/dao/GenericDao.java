package com.softenza.training.dao;

import java.util.List;

import org.hibernate.Session;

public interface GenericDao<E,K> {
	public E persist(E entity);
	public E merge(E entity);
	public void delete(E entity);
	public E find(Class cl, Long key);
	public List<E> getAll(Class cl);
	public Session getConnection();
	
}
