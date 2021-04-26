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
import com.example.demo.Service.FoodDonationService;
import com.example.demo.Service.LogisticDonationService;

@RestController
public class LogisticDonationController {
	@Autowired
	LogisticDonationService logisticDonationService;

	@PostMapping("insertLogisticDonationRequest")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> insertDonationRequest(@RequestBody LogisticDonationRequest logisticDonationRequest){
		try {
			System.out.println(logisticDonationRequest);
			return new ResponseEntity<Object>(logisticDonationService.insertRequest(logisticDonationRequest),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("getAllLogisticDonationRequests")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<LogisticDonationRequest>> getAllRequests(){
		return new ResponseEntity<List<LogisticDonationRequest>>(logisticDonationService.getAllRequests(),HttpStatus.OK);
	}
	
	@PostMapping("getLogisticDonationRequestsById")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<LogisticDonationRequest>> getRequestsById(@RequestBody LogisticDonationRequest logisticDonationRequest){
		return new ResponseEntity<List<LogisticDonationRequest>>(logisticDonationService.getRequestsByUserid(logisticDonationRequest.getUserId()),HttpStatus.OK);
	}
	

	@PostMapping("changeStatusLogisticDonationRequest")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> changeStatus(@RequestBody LogisticDonationRequest logisticDonationRequest){
		return new ResponseEntity<Object>(logisticDonationService.updateStatus(logisticDonationRequest.getDonationId(),logisticDonationRequest.getStatus()),HttpStatus.OK);
	}
	@GetMapping("getAllPendingLogisticDonationRequests")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<LogisticDonationRequest>> getAllPendingRequests(){
		return new ResponseEntity<List<LogisticDonationRequest>>(logisticDonationService.getAllPendingDonors(),HttpStatus.OK);
	}
	
//	
//	@PostMapping("getStatus")
//	@CrossOrigin(origins="http://localhost:4200")
//	public ResponseEntity<Object> getStatus(@RequestBody LogisticDonationRequest logisticDonationRequest){
//		return new ResponseEntity<Object>(logisticDonationService.approveRequest(logisticDonationRequest.getDonationId()),HttpStatus.OK);
//	}
//	
	
	
	
}
