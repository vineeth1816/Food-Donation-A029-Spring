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

@RestController
public class FoodDonationController {
	@Autowired
	FoodDonationService foodDonationService;
	
	/*
	 * Controller method providing details from server and passing
	 * to service layer method of inserting food donar details.
	 */

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
	
	/*
	 * Controller method calling the service of the
	 *  service layer method to  veiw  food donar details.
	 */

	
	@GetMapping("getAllRequests")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodDonationRequest>> getAllRequests(){
		return new ResponseEntity<List<FoodDonationRequest>>(foodDonationService.getAllRequests(),HttpStatus.OK);
	}
	
	/*
	 * Controller method providing details from server and passing
	 * to service layer method of getrequestById for food donar details.
	 */

	
	@PostMapping("getrequestsById")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodDonationRequest>> getRequestsById(@RequestBody FoodDonationRequest foodDonationRequest){
		return new ResponseEntity<List<FoodDonationRequest>>(foodDonationService.getRequestsByUserid(foodDonationRequest.getUserId()),HttpStatus.OK);
	}
	
	/*
	 * Controller method providing details from server and passing
	 * to service layer method to change food donar status in  food donar details in database.
	 */

	
	@PostMapping("changeStatus")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> changeStatus(@RequestBody FoodDonationRequest foodDonationRequest){
		return new ResponseEntity<Object>(foodDonationService.updateStatus(foodDonationRequest.getDonationId(),foodDonationRequest.getStatus()),HttpStatus.OK);
	}
	
	
//	@PostMapping("getStatus")
//	@CrossOrigin(origins="http://localhost:4200")
//	public ResponseEntity<Object> getStatus(@RequestBody FoodDonationRequest foodDonationRequest){
//		return new ResponseEntity<Object>(foodDonationService.approveRequest(foodDonationRequest.getDonationId()),HttpStatus.OK);
//	}
	
	
	
	
}
