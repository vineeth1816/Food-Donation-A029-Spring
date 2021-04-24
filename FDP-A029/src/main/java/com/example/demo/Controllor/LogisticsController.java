package com.example.demo.Controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
