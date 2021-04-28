package com.example.demo.Controllor;


import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.FoodRequest;
import com.example.demo.Model.MappedRequests;
import com.example.demo.Service.MappingService;
import com.fasterxml.jackson.databind.util.JSONPObject;
 

@RestController
public class MappingController {

	@Autowired
	MappingService mappingService;
	
	/*
	 * Method calling the mapRequestDonar service 
	 * to map food donar and food request requests.
	 */
	@GetMapping("mapRequestToDonor/{requestId}/{donorID}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> mapRequestDonor(@PathVariable String requestId,@PathVariable String donorID){
		System.out.println(requestId);
		Boolean valid=mappingService.mapRequestDonor(requestId, donorID);
		
		if(valid)
			return new ResponseEntity<Object>(valid,HttpStatus.OK);
		return new ResponseEntity<Object>(valid,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * Method used to call getAllRequests service to obtain all mapped request details.
	 */

	@GetMapping("getAllMappedRequests")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<MappedRequests>> getAllRequests(){
		return new ResponseEntity<List<MappedRequests>>(mappingService.getAllRequests(),HttpStatus.OK);
	}
}
