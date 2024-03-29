package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.MappingDaoImpl;
import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.FoodRequest;
import com.example.demo.Model.LogisticDonationRequest;
import com.example.demo.Model.MappedRequests;

@Service
public class MappingService {
	
	@Autowired
	MappingDaoImpl mappingDaoImpl;

	/*Service method used to call the mapRequestDonar method*/
	public Boolean mapRequestDonor(String requestId,String donorId)
	{
		return mappingDaoImpl.mapRequestDonor(requestId, donorId);
	}
	
	/*
	 * Method used to call the getAllRequest method
	 */

	public List<MappedRequests> getAllRequests(){
		return mappingDaoImpl.getAllRequests();
	}
}
