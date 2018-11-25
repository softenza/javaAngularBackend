package com.softenza.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softenza.training.model.BaseEntity;
import com.softenza.training.model.User;
import com.softenza.training.service.GenericService;


@RestController
@RequestMapping(value="/service/user")
@CrossOrigin
public class UserController {
 
	@Autowired 
	@Qualifier("genericService")
	GenericService genericService;
	
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public BaseEntity login() {
        return this.genericService.save(null);
    }
     
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public BaseEntity register(@RequestBody User user) {
	
		BaseEntity savedUser = this.genericService.save(user);
		
		return savedUser;
	}
    
  
}