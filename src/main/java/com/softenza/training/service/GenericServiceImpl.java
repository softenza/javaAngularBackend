package com.softenza.training.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softenza.training.dao.GenericDao;
import com.softenza.training.model.BaseEntity;
import com.softenza.training.model.Configuration;
import com.softenza.training.util.Constants;


@Service(value="genericService")
public class GenericServiceImpl implements GenericService {
	
	Map<String, List<String>> entityCascades;
	
	@Autowired
	GenericDao<BaseEntity, String> genericDao;
	
	public GenericServiceImpl() {
		this.entityCascades = new HashMap<String, List<String>>();
		this.entityCascades.put("Department", Arrays.asList(new String[]{"User"}));
	}
	
	@Transactional
	public BaseEntity save(BaseEntity entity) {	
		BaseEntity savedEntity = entity;
		try {
			entity.setModDate(new Date());                    
			entity.setModifiedBy(1L);    
			if (entity.getId() == null) {
				entity.setCreateDate(new Date());                  
				savedEntity = this.genericDao.persist(entity);
			} else {	
				savedEntity = this.genericDao.merge(entity);
			}
			savedEntity.setError(Constants.SUCCESS);
				
		}
		catch(Exception e) {
			e.printStackTrace();
			savedEntity.setError(e.getMessage());
		}
		
		return savedEntity;
	}
	
	@Transactional
	public void delete(BaseEntity entity) {
		this.genericDao.delete(entity);
	}
	
	@Transactional
	public void delete(Class cl, Long id) {
		BaseEntity entity = this.genericDao.find(cl, id);
		this.genericDao.delete(entity);
	}

	public BaseEntity find(Class cl, Long key) {
		return (BaseEntity) this.genericDao.find(cl, key);
	}
	
	public Double findByColumn(Class cl, String column, String value) {
		List<BaseEntity> list = this.genericDao.findByColumn(cl, column, value);
		
		if (list.size() > 0) {
			Configuration config = (Configuration) list.get(0);
			return new Double(config.getValue());
		}
		return null;
	}

	public List<BaseEntity> getAll(Class cl) {
		return this.genericDao.getAll(cl);
	}
	
	public Session getConnection() {
		return this.genericDao.getConnection();
	}
	
}
