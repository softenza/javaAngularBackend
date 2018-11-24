package com.softenza.training.dao;

import java.util.List;

import org.jboss.logging.Logger;

import com.softenza.training.model.BaseEntity;


public class BaseDaoImpl implements BaseDao {

	private static Logger logger = Logger.getLogger(BaseDaoImpl.class) ;
	
	
	public void persist(BaseEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void merge(BaseEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void remove(BaseEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void refresh(BaseEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public BaseEntity find(Class<BaseEntity> cl, Long key) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BaseEntity> getAll(Class<BaseEntity> cl) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

}
