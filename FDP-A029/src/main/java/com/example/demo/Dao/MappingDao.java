package com.example.demo.Dao;

import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.FoodRequest;

public interface MappingDao {

	public Boolean mapRequestDonor(String requestID, String donorID);
}
