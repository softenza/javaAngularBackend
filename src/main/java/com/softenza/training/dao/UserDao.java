package com.softenza.training.dao;

import java.util.List;

import com.softenza.training.model.Reservation;
import com.softenza.training.model.User;

public interface UserDao {
	public User getUser(String email, String password);
	
	public List<Reservation> getReservations(Long userId);
}
