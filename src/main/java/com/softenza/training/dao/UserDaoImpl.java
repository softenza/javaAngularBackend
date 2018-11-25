package com.softenza.training.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softenza.training.model.Reservation;
import com.softenza.training.model.User;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl implements UserDao{
	private static Logger logger = Logger.getLogger(UserDaoImpl.class) ;
	
	@Autowired
	private EntityManager entityManager;

	public User getUser(String email, String password) {

		User user = null;
		if(email == null){
			email = "";
		}
		if(password == null){
			password = "";
		}
		
		List list = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
			    .setParameter("email", email)
			    .setParameter("password", password)
			    .getResultList();
		
		if (list.size() > 0) {
			logger.info("Nombre d'utilisateur trouve avec les parametres {0}" + list.size());
			user = (User) list.get(0);
			
			logger.info("L'utilisateur trouve: " +user);
		} 
		else {
			logger.info("Aucun utilisateur match la critere de recherche");
		}

		return user;
	}

	public List<Reservation> getReservations(Long userId) {

		List<Reservation> reservations = null;
		if (userId == null) {
			return null;
		}
		
		reservations = entityManager.createQuery("SELECT r FROM Reservation r WHERE r.user.id = :userId")
			    .setParameter("userId", userId)
			    .getResultList();
		
		return reservations;
	}

}
