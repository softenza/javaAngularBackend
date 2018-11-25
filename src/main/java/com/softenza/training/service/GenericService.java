package com.softenza.training.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.softenza.training.model.BaseEntity;


@Service(value="genericService")
public interface GenericService {
	
	public BaseEntity save(BaseEntity entity);
	public void delete(BaseEntity entity);
	public void delete(Class cl, Long id);
	public BaseEntity find(Class cl, Long key);
	public Double findByColumn(Class cl, String column, String value);
	public List<BaseEntity> getAll(Class cl);
	public Session getConnection();
}
