package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.RegistrationDao;
import com.example.demo.Model.User;

@Component
public class RegistrationService {
	@Autowired
	RegistrationDao reg;

	public User registerUser(User user) {
	System.out.println("inside service");
	
	System.out.println("inside service");
	User u = reg.insertUser(user);
	
	return u;
	
}
}
