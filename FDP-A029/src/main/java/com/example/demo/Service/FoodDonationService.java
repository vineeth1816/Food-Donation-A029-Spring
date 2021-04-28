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
	
	/*
	 * Service method calling the insertRequest method in Fooddonation Implementation.
	 */
	
	public FoodDonationRequest insertRequest(FoodDonationRequest foodDonationRequest) {
		//System.out.println(foodDonationRequest);
		return foodDonationDaoImpl.insertRequest(foodDonationRequest);
	}
	
	/*
	 * Service method calling the getAllRequest method in Fooddonation Implementation.
	 */
	public List<FoodDonationRequest> getAllRequests(){
		return foodDonationDaoImpl.getAllRequests();
	}
	
	/*
	 * Service method calling the getRequestById method in Fooddonation Implementation.
	 */
	public List<FoodDonationRequest> getRequestsByUserid(String userid){
		return foodDonationDaoImpl.getRequestsById(userid);
	}
	
	/*
	 * Service method calling the updateStatus method in Fooddonation Implementation.
	 */
	public Boolean updateStatus(String donationId,String status) {
		return foodDonationDaoImpl.updateStatus(donationId,status);
	}
	
	/*
	 * Service method calling the getAllApprovedRequest method in Fooddonation Implementation.
	 */
	public List<FoodDonationRequest> getAllApprovedDonors(){
		return foodDonationDaoImpl.getAllApprovedRequests();
	}
	
	
//	public String getStatus(String donationId) {
//		return null;
//	}
}
