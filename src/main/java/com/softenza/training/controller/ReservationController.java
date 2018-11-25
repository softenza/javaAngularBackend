package com.softenza.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softenza.training.model.BaseEntity;
import com.softenza.training.model.Reservation;
import com.softenza.training.model.User;
import com.softenza.training.service.GenericService;
import com.softenza.training.service.UserService;


@RestController
@RequestMapping(value="/service/reservation")
@CrossOrigin
public class ReservationController {
 
	@Autowired 
	@Qualifier("userService")
	UserService userService;
	
	@Autowired 
	@Qualifier("genericService")
	GenericService genericService;
	
  
    @RequestMapping(value="/getUserReservations/{userId}", method = RequestMethod.GET)
    public List<Reservation> getUserReservations(@PathVariable Long userId) {
  
        return this.userService.getReservations(userId);
    }
    
    @RequestMapping(value="/getAllReservations", method = RequestMethod.GET)
    public List<BaseEntity> getAllReservations() {
  
        return this.genericService.getAll(Reservation.class);
    }
    
    @RequestMapping(value="/reserver", method = RequestMethod.POST)
    public BaseEntity register(@RequestBody Reservation reservation) {
    	BaseEntity savedReservation = this.genericService.save(reservation);
    	
		return savedReservation;
	}
  
}