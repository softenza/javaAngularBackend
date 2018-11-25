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
import com.softenza.training.model.Configuration;
import com.softenza.training.model.Reservation;
import com.softenza.training.model.User;
import com.softenza.training.service.GenericService;
import com.softenza.training.service.UserService;
import com.softenza.training.util.Constants;


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
    public BaseEntity reserver(@RequestBody Reservation reservation) {
    	BaseEntity savedReservation = this.genericService.save(reservation);
    	
		return savedReservation;
	}
    
    @RequestMapping(value="/review", method = RequestMethod.POST)
    public BaseEntity review(@RequestBody Reservation reservation) {
    	BaseEntity savedReservation = this.genericService.save(reservation);
    	
		return savedReservation;
	}
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
    	
    	String result = Constants.SUCCESS;
    	
    	try {
    		this.genericService.delete(Reservation.class, id);
    	}
    	catch(Exception e) {
    		result = e.getMessage();
    	}
    	
    	return result;
    }
    
    @RequestMapping(value="/confirmer", method = RequestMethod.POST)
    public String confirmer(@RequestBody Reservation reservation) {
    	
    	String result = Constants.SUCCESS;
    	
    	try {
    		this.genericService.save(reservation);
    	}
    	catch(Exception e) {
    		result = e.getMessage();
    	}
    	
    	return result;
    	
	}
  
    @RequestMapping(value="/terminer", method = RequestMethod.POST)
    public String terminer(@RequestBody Reservation reservation) {
    	
    	String result = Constants.SUCCESS;
    	
    	try {
    		this.genericService.save(reservation);
    	}
    	catch(Exception e) {
    		result = e.getMessage();
    	}
    	
    	return result;
    	
	}
    
    @RequestMapping(value="/getUnitCost", method = RequestMethod.GET)
    public Double getUnitCost(@PathVariable Long id) {
    	
    	Double result = null;
    	
    	try {
    		result = this.genericService.findByColumn(Configuration.class, "NAME", "UNIT_PRICE");
    	}
    	catch(Exception e) {
    		result = null;
    	}
    	
    	return result;
    }
}