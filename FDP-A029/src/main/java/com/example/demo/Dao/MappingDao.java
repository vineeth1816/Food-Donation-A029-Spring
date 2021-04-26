package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.FoodRequest;
import com.example.demo.Model.MappedRequests;

public interface MappingDao {

	public Boolean mapRequestDonor(String requestID, String donorID);

	public List<MappedRequests> getAllRequests();
}
