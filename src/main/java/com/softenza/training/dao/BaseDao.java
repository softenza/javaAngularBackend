package com.softenza.training.dao;

import java.util.List;

import com.softenza.training.model.BaseEntity;


public interface BaseDao {

	public void persist(BaseEntity entity);

	public void merge(BaseEntity entity);

	public void remove(BaseEntity entity);

	public void refresh(BaseEntity entity);

	public BaseEntity find(Class<BaseEntity> cl, Long key);

	public List<BaseEntity> getAll(Class<BaseEntity> cl);
	
	public void flush();
}
