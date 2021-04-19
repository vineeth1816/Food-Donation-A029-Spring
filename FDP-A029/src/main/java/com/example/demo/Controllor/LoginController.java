package com.example.demo.Controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) {

		User u = loginService.loginUser(user);
		return u;

	}

	@GetMapping("/getUser/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@PathVariable String id) {

		System.out.println(id);
		User u = loginService.getUser(id);
		return u;

	}
}
