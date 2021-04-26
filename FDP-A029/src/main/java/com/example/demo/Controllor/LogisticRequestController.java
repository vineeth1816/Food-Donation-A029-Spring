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
import com.example.demo.Model.LogisticDonationRequest;
import com.example.demo.Model.LogisticRequest;
import com.example.demo.Service.FoodDonationService;
import com.example.demo.Service.LogisticDonationService;
import com.example.demo.Service.LogisticRequestService;

@RestController
public class LogisticRequestController {
	@Autowired
	LogisticRequestService logisticRequestService;

	@PostMapping("insertLogisticRequest")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> insertDonationRequest(@RequestBody LogisticRequest logisticRequest){
		try {
			System.out.println(logisticRequest);
			return new ResponseEntity<Object>(logisticRequestService.insertRequest(logisticRequest),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("getAllLogisticRequests")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<LogisticRequest>> getAllRequests(){
		return new ResponseEntity<List<LogisticRequest>>(logisticRequestService.getAllRequests(),HttpStatus.OK);
	}
	
//	@PostMapping("getrequestsById")
//	@CrossOrigin(origins="http://localhost:4200")
//	public ResponseEntity<List<FoodDonationRequest>> getRequestsById(@RequestBody FoodDonationRequest foodDonationRequest){
//		return new ResponseEntity<List<FoodDonationRequest>>(foodDonationService.getRequestsByUserid(foodDonationRequest.getUserId()),HttpStatus.OK);
//	}
//	
//	
//	@PostMapping("changeStatus")
//	@CrossOrigin(origins="http://localhost:4200")
//	public ResponseEntity<Object> changeStatus(@RequestBody FoodDonationRequest foodDonationRequest){
//		return new ResponseEntity<Object>(foodDonationService.updateStatus(foodDonationRequest.getDonationId(),foodDonationRequest.getStatus()),HttpStatus.OK);
//	}
//	
//	
//	@PostMapping("getStatus")
//	@CrossOrigin(origins="http://localhost:4200")
//	public ResponseEntity<Object> getStatus(@RequestBody FoodDonationRequest foodDonationRequest){
//		return new ResponseEntity<Object>(foodDonationService.approveRequest(foodDonationRequest.getDonationId()),HttpStatus.OK);
//	}
	
	
	
	
}
