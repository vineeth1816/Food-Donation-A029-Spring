package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.setPasswordDaoImpl;
import com.example.demo.Model.User;

@Service
public class SetNewPasswordService {
	@Autowired
	setPasswordDaoImpl SetPasswordDaoImpl; 
	
	public boolean updatePassword(User user) {
		return  SetPasswordDaoImpl.updatePassword(user);
	}

}
