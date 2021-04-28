package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.LogisticDonationRequest;
import com.example.demo.Model.LogisticRequest;

public interface LogisticRequestDao {

	public LogisticRequest insertRequest(LogisticRequest logisticRequest);
	public List<LogisticRequest> getAllRequests();
	
//	public List<FoodDonationRequest> getRequestsById(String userId);
//	public Boolean updateStatus(String donationId,String status);
//	public List<FoodDonationRequest> getAllApprovedRequests();
//	
//	
//	public String getStatus(String donationId);
}
