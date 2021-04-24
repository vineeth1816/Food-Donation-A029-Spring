package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.FoodDonationDaoImpl;
import com.example.demo.DaoImpl.FoodRequestDaoImpl;
import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.FoodRequest;


@Service
public class FoodRequestService {

	@Autowired
	FoodRequestDaoImpl foodRequestDaoImpl;
	
	public FoodRequest insertFoodRequest(FoodRequest foodRequest) {
		System.out.println(foodRequest);
		return foodRequestDaoImpl.insertFoodRequest(foodRequest);
	}
	
	public List<FoodRequest> getAllFoodRequests(){
		return foodRequestDaoImpl.getAllFoodRequests();
	}
	
	public List<FoodRequest> getFoodRequestsByUserid(String userid){
		return foodRequestDaoImpl.getFoodRequestsById(userid);
	}
	
	
	public Boolean updateStatus(String donationId,String status) {
		return foodRequestDaoImpl.updateStatus(donationId,status);
	}
	
	public Boolean insertAdminRequest(String requestId,String category) {
		return foodRequestDaoImpl.insertAdminRequest(requestId, category);
	}
}
