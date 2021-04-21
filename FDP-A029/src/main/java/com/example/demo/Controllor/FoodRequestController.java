package com.example.demo.Controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.FoodRequest;
import com.example.demo.Service.FoodDonationService;
import com.example.demo.Service.FoodRequestService;

@RestController
public class FoodRequestController {
	@Autowired
	FoodRequestService foodRequestService;

	@PostMapping("insertFoodRequest")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> insertFoodRequest(@RequestBody FoodRequest foodRequest){
		try {
			System.out.println(foodRequest);
			return new ResponseEntity<Object>(foodRequestService.insertFoodRequest(foodRequest),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("getAllFoodRequests")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodRequest>> getAllFoodRequests(){
		return new ResponseEntity<List<FoodRequest>>(foodRequestService.getAllFoodRequests(),HttpStatus.OK);
	}
	
	@GetMapping("getFoodRequestById")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodRequest>> getRequestsById(@RequestBody FoodRequest foodRequest){
		return new ResponseEntity<List<FoodRequest>>(foodRequestService.getFoodRequestsByUserid(foodRequest.getUserId()),HttpStatus.OK);
	}
	
	
}
