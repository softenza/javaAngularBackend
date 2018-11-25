package com.softenza.training.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softenza.training.dao.UserDao;
import com.softenza.training.model.BaseEntity;
import com.softenza.training.model.Reservation;
import com.softenza.training.model.User;
import com.softenza.training.util.Constants;


@Service(value="userService")
public class UserServiceImpl  implements UserService {
	
	@Autowired
	GenericService genericService;
	
	@Autowired
	UserDao userDao;
	
	@Transactional
	public BaseEntity save(User entity) {		
		User user = entity;
		String error = Constants.SUCCESS;
		try {
			
	        user = (User) genericService.save(entity);
	        if (user == null) {
				error = "L'utilisateur n'a pas ete sauvegarde";
			} 

		} catch (Exception e) {
			error = e.getMessage();
		} 
				
		user.setError(error);
		return genericService.save(entity);		
	}

	@Transactional
	public User getUser(String email, String password) {
		User user = null;
		String error = Constants.SUCCESS;
		try {
			user = userDao.getUser(email, password);
			if (user == null) {
				error = "Nom d'utilisateur ou mot de passe invalid";
			} 
		}
		catch(Exception e) {
			user = new User();
			error = e.getMessage();
		}
		
		user.setError(error);
		return user;
	}
	
	@Transactional
	public List<Reservation> getReservations(Long userId) {
		
		return this.userDao.getReservations(userId);
	}
}
