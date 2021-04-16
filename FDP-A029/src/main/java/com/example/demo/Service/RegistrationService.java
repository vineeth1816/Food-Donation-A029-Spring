package com.example.demo.Service;


import org.springframework.stereotype.Service;

import com.example.demo.Dao.RegistrationDao;
import com.example.demo.DaoImpl.RegistrationDaoImpl;
import com.example.demo.Model.User;

@Service
public class RegistrationService {

	public User registerUser(User user) {
	RegistrationDao reg = new RegistrationDaoImpl();
	User u = reg.insertUser(user);
	
	return u;
	
}
}
