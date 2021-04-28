package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.LogisticsDao;
import com.example.demo.Model.MappedRequests;
import com.example.demo.Model.Vehicle;

@Service
public class LogisticsServices {
	
	@Autowired
	LogisticsDao ldao;

	/*
	 * Service calling the addvehicle method to add vehicle details.
	 */
	public boolean addVehicleService(Vehicle v) {
		boolean flag=ldao.addVehicle(v.getVehicleNo(),v.getDriverName(),v.getLocation());
		return flag;
	}
	
	/*
	 * Service calling the getAllRequest method to get request details.
	 */
	public List<Vehicle> getAllRequests(String donaitonId){
		return ldao.getAllRequests(donaitonId);
	}
	
	/*
	 * Service calling the updateVehicle method to update vehicle status.
	 */
	
	public boolean updateVehicle(String vehicleNo,String donationId,String requestId){
		return ldao.updateVehicle(vehicleNo,donationId,requestId);
	}
}
