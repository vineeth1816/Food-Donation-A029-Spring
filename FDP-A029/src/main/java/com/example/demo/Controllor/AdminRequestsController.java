package com.example.demo.Controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.FoodRequest;
import com.example.demo.Service.AdminRequestsService;
@RestController
public class AdminRequestsController {
	
	@Autowired
	AdminRequestsService adminRequestsService;
	
	@GetMapping("getAllAdminFoodRequests/{category}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodRequest>> getAllFoodRequests(@PathVariable String category){
		try {
			System.out.println(category);
		return new ResponseEntity<List<FoodRequest>>(adminRequestsService.getAllFoodRequests(category),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<FoodRequest>>(adminRequestsService.getAllFoodRequests(category),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
