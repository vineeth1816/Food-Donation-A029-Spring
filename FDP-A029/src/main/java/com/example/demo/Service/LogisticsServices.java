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

	
	public boolean addVehicleService(Vehicle v) {
		boolean flag=ldao.addVehicle(v.getVehicleNo(),v.getDriverName(),v.getLocation());
		return flag;
	}
	
	public List<Vehicle> getAllRequests(String donaitonId){
		return ldao.getAllRequests(donaitonId);
	}
	
	public boolean updateVehicle(String vehicleNo,String donationId,String requestId){
		return ldao.updateVehicle(vehicleNo,donationId,requestId);
	}
}
