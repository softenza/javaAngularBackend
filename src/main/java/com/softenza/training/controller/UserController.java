package com.softenza.training.controller;

import java.util.List;

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
import com.softenza.training.service.UserService;


@RestController
@RequestMapping(value="/service/user")
@CrossOrigin
public class UserController {
 
	@Autowired 
	@Qualifier("genericService")
	GenericService genericService;
	
	@Autowired 
	@Qualifier("userService")
	UserService userService;
	
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public BaseEntity login(@RequestBody User user) {
  
        return this.userService.getUser(user.getEmail(), user.getPassword());
    }
     
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public BaseEntity register(@RequestBody User user) {
    	BaseEntity savedUser = this.userService.save(user);
    	
		return savedUser;
	}
    
    @RequestMapping(value="/getAllClients", method = RequestMethod.GET)
    public List<BaseEntity> getAllClients() {
  
        return this.genericService.getAll(User.class);
    }
  
}