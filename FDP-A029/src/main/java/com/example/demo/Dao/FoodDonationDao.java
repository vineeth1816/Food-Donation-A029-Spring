package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodDonationRequest;

public interface FoodDonationDao {
	/*
	 * FoodDonation Dao interface providing the methods 
	 * to be implemented in FoodDonationImplementation.
	 */

	public FoodDonationRequest insertRequest(FoodDonationRequest foodDonationRequest);
	public List<FoodDonationRequest> getAllRequests();
	public List<FoodDonationRequest> getRequestsById(String userId);
	public Boolean updateStatus(String donationId,String status);
	public List<FoodDonationRequest> getAllApprovedRequests();
	
	
	public String getStatus(String donationId);
}
