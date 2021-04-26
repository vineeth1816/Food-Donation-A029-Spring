package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.LogisticDonationRequest;

public interface LogisticDonationDao {

	public LogisticDonationRequest insertRequest(LogisticDonationRequest logisticDonationRequest);
	public List<LogisticDonationRequest> getAllRequests();
//	public List<FoodDonationRequest> getRequestsById(String userId);
//	public Boolean updateStatus(String donationId,String status);
//	public List<FoodDonationRequest> getAllApprovedRequests();
//	
//	
//	public String getStatus(String donationId);
}
