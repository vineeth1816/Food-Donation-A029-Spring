package com.example.demo.Controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.FoodRequest;
import com.example.demo.Model.LogisticRequest;
import com.example.demo.Service.AdminRequestsService;
@RestController
public class AdminRequestsController {
	
	@Autowired
	AdminRequestsService adminRequestsService;
	
	@GetMapping("getAllAdminFoodRequests/{category}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodRequest>> getAllFoodRequests(@PathVariable String category){
		try {
			
		return new ResponseEntity<List<FoodRequest>>(adminRequestsService.getAllFoodRequests(category),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<FoodRequest>>(adminRequestsService.getAllFoodRequests(category),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("getAllAdminLogisticRequests/{category}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<LogisticRequest>> getAllLogisticRequests(@PathVariable String category){
		try {
			
		return new ResponseEntity<List<LogisticRequest>>(adminRequestsService.getAllLogisticRequests(category),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<LogisticRequest>>(adminRequestsService.getAllLogisticRequests(category),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("getAllAdminFoodRequestsOrderBy/{category}/{column}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodRequest>> getAllFoodRequests(@PathVariable String category,@PathVariable String column){
		try {
			System.out.println(category);
			System.out.println(adminRequestsService.getAllFoodRequestsOrderByColumn(category,column));
		return new ResponseEntity<List<FoodRequest>>(adminRequestsService.getAllFoodRequestsOrderByColumn(category,column),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<FoodRequest>>(adminRequestsService.getAllFoodRequestsOrderByColumn(category,column),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	@GetMapping("checkRequestId/{requestId}/{category}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Boolean> checkRequest(@PathVariable String requestId,@PathVariable String category){
		System.out.println("Hello welcome");
		Boolean available;
		try{
		available=adminRequestsService.checkRequestId(requestId, category);
		
		return new ResponseEntity<Boolean>(available,HttpStatus.OK);
		}
		catch (Exception e) {
			
			available=false;
			return new ResponseEntity<Boolean>(available,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("deleteRequest/{requestId}/{category}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Boolean> deleteRequest(@PathVariable String requestId,@PathVariable String category){
		Boolean deleted;
		try
		{
		deleted=adminRequestsService.deleteRequest(requestId, category);
		
		return new ResponseEntity<Boolean>(deleted,HttpStatus.OK);
		}
		catch (Exception e) {
			deleted=false;
			return new ResponseEntity<Boolean>(deleted,HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	
	
	

}
