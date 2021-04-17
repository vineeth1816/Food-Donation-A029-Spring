package com.example.demo.Controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.RegistrationService;

@RestController
public class RegistrationController{
	
	@Autowired
	RegistrationService registrationService;
	@PostMapping("/register")

	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object>  registerUser(@RequestBody User u) {
		try {
		User user=registrationService.registerUser(u);
		return new ResponseEntity<Object>(user, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

}

}
