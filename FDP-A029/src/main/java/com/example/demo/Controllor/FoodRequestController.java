package com.example.demo.Controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	FoodDonationService foodDonationService;
	
	/*
	 * Controller method used to insert the food request details.
	 */

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
	
	/*
	 * Controller method used to retrieve all  the food request details.
	 */
	@GetMapping("getAllFoodRequests")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodRequest>> getAllFoodRequests(){
		System.out.println(foodRequestService.getAllFoodRequests());
		return new ResponseEntity<List<FoodRequest>>(foodRequestService.getAllFoodRequests(),HttpStatus.OK);
	}
	
	/*
	 * Controller method used to get details  the food request of a specified Requester.
	 */
	@PostMapping("getFoodRequestById")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodRequest>> getRequestsById(@RequestBody FoodRequest foodRequest){
		return new ResponseEntity<List<FoodRequest>>(foodRequestService.getFoodRequestsByUserid(foodRequest.getUserId()),HttpStatus.OK);
	}
	
	/*
	 * Controller method used to update the food request status of a particular user.
	 */
	
	@PostMapping("changeFoodRequestStatus")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> changeFoodRequestStatus(@RequestBody FoodRequest foodRequest){
		return new ResponseEntity<Object>(foodRequestService.updateStatus(foodRequest.getRequestId(),foodRequest.getStatus()),HttpStatus.OK);
	}
	
	/* This method is used to retrieve all Approved Donors for mapping to a request ID*/
	@GetMapping("getAllApprovedDonors")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodDonationRequest>> getAllApprovedFoodDonors(){
		return new ResponseEntity<List<FoodDonationRequest>>(foodDonationService.getAllApprovedDonors(),HttpStatus.OK);
	}
	
	/*
	 * Controller method used to insert the admin food request details.
	 */
	@GetMapping("insertAdminRequest/{requestId}/{category}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> insertAdminRequest(@PathVariable String requestId,@PathVariable String category){
		System.out.println(requestId + "in controller");
		Boolean valid=foodRequestService.insertAdminRequest(requestId,category);
		if(valid)
		return new ResponseEntity<Object>(valid,HttpStatus.OK);
		
		return new ResponseEntity<Object>(valid,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
	
	
	
	
}
