package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.RegistrationDao;
import com.example.demo.DaoImpl.RegistrationDaoImpl;
import com.example.demo.Model.User;

@Service
public class RegistrationService {
	@Autowired
	RegistrationDao reg;

	public User registerUser(User user) {
	User u = reg.insertUser(user);
	
	return u;
	
}
}
