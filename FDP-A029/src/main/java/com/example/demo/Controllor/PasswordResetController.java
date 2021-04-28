package com.example.demo.Controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.ValidateForgetPasswordService;

@RestController
public class PasswordResetController {
	@Autowired
	ValidateForgetPasswordService ValidateForgetPasswordService;
	
	/*
	 * Method used to call validateDetails service method for password resetting.
	 */

	@PostMapping("validatePasswordReset")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> validatePasswordReset(@RequestBody User u){
		try {
		
		return new ResponseEntity<Object>(ValidateForgetPasswordService.validateDetails(u),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
