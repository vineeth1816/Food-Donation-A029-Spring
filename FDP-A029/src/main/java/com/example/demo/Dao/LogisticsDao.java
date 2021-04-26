package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.Vehicle;

public interface LogisticsDao {

	public Boolean addVehicle(String Vehicleno,String Drivername,String Location);
	public List<Vehicle> getAllRequests(String donationId);
	public boolean updateVehicle(String vehicleNo,String donationId,String requestId);
}
