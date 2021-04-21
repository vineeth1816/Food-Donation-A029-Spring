package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodRequest;

public interface FoodRequestDao {

	public FoodRequest insertFoodRequest(FoodRequest foodRequest);
	public List<FoodRequest> getAllFoodRequests();
	public List<FoodRequest> getFoodRequestsById(String userId);
}
