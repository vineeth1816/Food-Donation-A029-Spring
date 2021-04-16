package com.example.demo.Controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.RegistrationService;

@RestController
public class RegistrationController{
	@Autowired
	RegistrationService registrationService;
	@PostMapping("register")
	public ResponseEntity<User>  registerUser(@RequestBody User u) {
	
		return new ResponseEntity(registrationService.registerUser(u), HttpStatus.OK);
		

}
}
