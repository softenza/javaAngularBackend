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
	@Qualifier("userService")
	GenericService genericService;
	
    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return
          user.getEmail().equals("user") && user.getPassword().equals("password");
    }
     
    
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public BaseEntity register(@RequestBody User user) {
	
		BaseEntity savedUser = this.genericService.save(user);
		
		return savedUser;
	}
    
  
}