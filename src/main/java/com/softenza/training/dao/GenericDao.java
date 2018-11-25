package com.softenza.training.dao;

import java.util.List;

import org.hibernate.Session;

import com.softenza.training.model.BaseEntity;

public interface GenericDao<E,K> {
	public E persist(E entity);
	public E merge(E entity);
	public void delete(E entity);
	public E find(Class cl, Long key);
	public List<BaseEntity> findByColumn(Class cl, String column, String value);
	public List<E> getAll(Class cl);
	public Session getConnection();
	
}
