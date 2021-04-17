package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.ValidateForgotPasswordDaoImpl;
import com.example.demo.Model.User;

@Service
public class ValidateForgetPasswordService {
	@Autowired
	ValidateForgotPasswordDaoImpl validateForgotPasswordDaoImpl;
	
	public boolean validateDetails(User u) {
		try {
		User user1=validateForgotPasswordDaoImpl.getUser(u.getUserId());
		if(user1.getUserId().equals(u.getUserId()) && user1.getSq1().equals(u.getSq1()) && user1.getSq2().equals(u.getSq2()) && user1.getSq3().equals(u.getSq3()))
		{
			
			return true;
		}
		}
		catch(Exception e) {
			return false;
		}
		
		
		
		return false;
	}

}
