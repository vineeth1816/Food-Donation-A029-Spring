package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.LogisticDonationRequest;

public interface LogisticDonationDao {

	public LogisticDonationRequest insertRequest(LogisticDonationRequest logisticDonationRequest);
	public List<LogisticDonationRequest> getAllRequests();
	public List<LogisticDonationRequest> getRequestsById(String userId);
	public Boolean updateStatus(String donationId,String status);
	public List<LogisticDonationRequest> getAllPendingDonors();
	
	
	public String getStatus(String donationId);
}
