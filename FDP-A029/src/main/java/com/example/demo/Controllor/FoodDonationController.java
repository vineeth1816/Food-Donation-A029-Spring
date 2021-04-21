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
import com.example.demo.Service.FoodDonationService;

@RestController
public class FoodDonationController {
	@Autowired
	FoodDonationService foodDonationService;

	@PostMapping("insertDonationRequest")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> insertDonationRequest(@RequestBody FoodDonationRequest foodDonationRequest){
		try {
			System.out.println(foodDonationRequest);
			return new ResponseEntity<Object>(foodDonationService.insertRequest(foodDonationRequest),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("getAllRequests")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodDonationRequest>> getAllRequests(){
		return new ResponseEntity<List<FoodDonationRequest>>(foodDonationService.getAllRequests(),HttpStatus.OK);
	}
	
	@PostMapping("getrequestsById")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodDonationRequest>> getRequestsById(@RequestBody FoodDonationRequest foodDonationRequest){
		return new ResponseEntity<List<FoodDonationRequest>>(foodDonationService.getRequestsByUserid(foodDonationRequest.getUserId()),HttpStatus.OK);
	}
	
	
}
