package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.FoodDonationDaoImpl;
import com.example.demo.DaoImpl.LogisticDonationDaoImpl;
import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.LogisticDonationRequest;

@Service
public class LogisticDonationService {

	@Autowired
	LogisticDonationDaoImpl logisticDonationDaoImpl;
	
	public LogisticDonationRequest insertRequest(LogisticDonationRequest logisticDonationRequest) {
		System.out.println(logisticDonationRequest);
		return logisticDonationDaoImpl.insertRequest(logisticDonationRequest);
	}
	
	public List<LogisticDonationRequest> getAllRequests(){
		return logisticDonationDaoImpl.getAllRequests();
	}
	
	public List<LogisticDonationRequest> getRequestsByUserid(String userid){
		return logisticDonationDaoImpl.getRequestsById(userid);
	}
	
	public Boolean updateStatus(String donationId,String status) {
		return logisticDonationDaoImpl.updateStatus(donationId,status);
	}
	
	public List<LogisticDonationRequest> getAllPendingDonors(){
		return logisticDonationDaoImpl.getAllPendingDonors();
	}
	
	
	public String getStatus(String donationId) {
		return null;
	}
}
