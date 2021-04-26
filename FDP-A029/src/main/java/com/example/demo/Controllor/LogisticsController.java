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

import com.example.demo.Model.MappedRequests;
import com.example.demo.Model.Vehicle;
import com.example.demo.Service.LogisticsServices;


@RestController
public class LogisticsController {
	@Autowired
	LogisticsServices logisticService;
	
	@PostMapping("addLogistics")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object>  addLogistics(@RequestBody Vehicle v) {
		System.out.println(v);
		boolean flag;
		try {
		 flag =logisticService.addVehicleService(v);
		return new ResponseEntity<Object>(flag, HttpStatus.OK);
		}
		catch (Exception e) {
			flag=false;
			return new ResponseEntity<Object>(flag, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		


}
	
	
	@GetMapping("getAllAvailableLogistics/{donationId}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<Vehicle>> getAllRequests(@PathVariable String donationId){
		return new ResponseEntity<List<Vehicle>>(logisticService.getAllRequests(donationId),HttpStatus.OK);
	}
	
	@GetMapping("updateVehicle/{vehicleNo}/{donationId}/{requestId}")
	@CrossOrigin(origins="http://localhost:4200")
	public boolean updateVehicle(@PathVariable String vehicleNo,@PathVariable String donationId,@PathVariable String requestId){
		return logisticService.updateVehicle(vehicleNo,donationId,requestId);
	}
}
