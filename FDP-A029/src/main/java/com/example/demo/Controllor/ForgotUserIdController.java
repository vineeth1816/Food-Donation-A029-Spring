package com.example.demo.Controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.ForgotUserIdService;

@RestController
public class ForgotUserIdController {
	@Autowired
	ForgotUserIdService forgotService;

	@PostMapping("forgotuserid")
	@CrossOrigin(origins="http://localhost:4200")
public User  registerUser(@RequestBody User user) {
		
		User us = forgotService.userIdRecovery(user);
		return us;//new ResponseEntity(registrationService.registerUser(u), HttpStatus.OK);
		

}
	
}
