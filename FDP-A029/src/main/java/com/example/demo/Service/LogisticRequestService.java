package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.FoodDonationDaoImpl;
import com.example.demo.DaoImpl.LogisticDonationDaoImpl;
import com.example.demo.DaoImpl.LogisticRequestDaoImpl;
import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.LogisticDonationRequest;
import com.example.demo.Model.LogisticRequest;

@Service
public class LogisticRequestService {

	@Autowired
	LogisticRequestDaoImpl logisticRequestDaoImpl;
	
	public LogisticRequest insertRequest(LogisticRequest logisticRequest) {
		System.out.println(logisticRequest);
		return logisticRequestDaoImpl.insertRequest(logisticRequest);
	}
	
	public List<LogisticRequest> getAllRequests(){
		return logisticRequestDaoImpl.getAllRequests();
	}
	
//	public List<FoodDonationRequest> getRequestsByUserid(String userid){
//		return foodDonationDaoImpl.getRequestsById(userid);
//	}
//	
//	public Boolean updateStatus(String donationId,String status) {
//		return foodDonationDaoImpl.updateStatus(donationId,status);
//	}
//	
//	public List<FoodDonationRequest> getAllApprovedDonors(){
//		return foodDonationDaoImpl.getAllApprovedRequests();
//	}
	
	
//	public String getStatus(String donationId) {
//		return null;
//	}
}
