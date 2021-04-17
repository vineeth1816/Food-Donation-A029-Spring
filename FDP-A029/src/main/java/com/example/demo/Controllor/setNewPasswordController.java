package com.example.demo.Controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.SetNewPasswordService;

@RestController
public class setNewPasswordController {
	
	@Autowired
	SetNewPasswordService setNewPasswordService;
	
	@PostMapping("setPassword")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> setNewPassword(@RequestBody User user){
		
		try {
			return new ResponseEntity<Object>(setNewPasswordService.updatePassword(user),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
