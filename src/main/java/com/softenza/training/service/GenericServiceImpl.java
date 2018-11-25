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

		entity.setModDate(new Date());                    
		entity.setModifiedBy(1L);    
		if (entity.getId() == null) {
			entity.setCreateDate(new Date());                  
			return this.genericDao.persist(entity);
		} else {	
			return this.genericDao.merge(entity);
		}
				             
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

	public List<BaseEntity> getAll(Class cl) {
		return this.genericDao.getAll(cl);
	}
	
	public Session getConnection() {
		return this.genericDao.getConnection();
	}
	
}
