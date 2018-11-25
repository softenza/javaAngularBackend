package com.softenza.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.softenza.training.model.BaseEntity;
import com.softenza.training.model.Reservation;
import com.softenza.training.model.User;


@Service(value="userService")
public interface UserService {
	
	public BaseEntity save(User entity);
	public User getUser(String email, String password);
	public List<Reservation> getReservations(Long userId);
}
