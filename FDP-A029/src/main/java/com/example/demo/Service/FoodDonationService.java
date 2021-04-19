package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.FoodDonationDaoImpl;
import com.example.demo.Model.FoodDonationRequest;

@Service
public class FoodDonationService {

	@Autowired
	FoodDonationDaoImpl foodDonationDaoImpl;
	
	public FoodDonationRequest insertRequest(FoodDonationRequest foodDonationRequest) {
		return foodDonationDaoImpl.insertRequest(foodDonationRequest);
	}
	
	public List<FoodDonationRequest> getAllRequests(){
		return foodDonationDaoImpl.getAllRequests();
	}
}
