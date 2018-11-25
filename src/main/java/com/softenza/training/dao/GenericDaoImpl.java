package com.softenza.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.jboss.logging.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unchecked")
@Repository
public class GenericDaoImpl<E, K> implements GenericDao<E, K> {
	private static Logger logger = Logger.getLogger(GenericDaoImpl.class) ;
	
	@Autowired
	private EntityManager entityManager;

	public E persist(E entity) {
	    entityManager.persist(entity);
		return entity;
	}

	public E merge(E entity) {
	    entityManager.merge(entity);
		return entity;
	}
	
	public void delete(E entity) {
		entityManager.remove(entity);
	}

	public void delete(Class cl, Long id) {
		this.delete(this.find(cl, id));
	}
	
	public E find(Class cl, Long key) {
		return (E) entityManager.find(cl, key);
	}

	public List<E> getAll(Class cl) {
		CriteriaQuery<E> criteria = entityManager.getCriteriaBuilder().createQuery(cl);
	    criteria.select(criteria.from(cl));
	    List<E> ListOfEmailDomains = entityManager.createQuery(criteria).getResultList();
	    return ListOfEmailDomains;
	}

	public Session getConnection() {
		return entityManager.unwrap(Session.class);
	}

}
