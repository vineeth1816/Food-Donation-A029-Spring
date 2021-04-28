package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.FoodRequest;
import com.example.demo.Model.MappedRequests;

public interface MappingDao {
	
	/*Mapping interface providing all the methods to be implemented in DaoIMPL*/

	public Boolean mapRequestDonor(String requestID, String donorID);

	public List<MappedRequests> getAllRequests();
}
