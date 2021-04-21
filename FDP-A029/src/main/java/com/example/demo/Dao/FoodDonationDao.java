package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodDonationRequest;

public interface FoodDonationDao {

	public FoodDonationRequest insertRequest(FoodDonationRequest foodDonationRequest);
	public List<FoodDonationRequest> getAllRequests();
	public List<FoodDonationRequest> getRequestsById(String userId);
}
