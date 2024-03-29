package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodRequest;
import com.example.demo.Model.LogisticRequest;

public interface AdminRequestsDao {
	
	/*
	 * This is the interface for all the methods called in 
	 * admin request services class and they are implemented
	 * in the Dao implementation class.
	 */

	public List<FoodRequest> getAllFoodRequests(String category);
	public List<LogisticRequest> getAllLogisticRequests(String category);
	public List<FoodRequest> getAllFoodRequestsOrderByDate(String category);
	public List<FoodRequest> getAllFoodRequestsOrderByLocation(String category);
	public List<FoodRequest> getAllFoodRequestsOrderByQuantity(String category);
	public List<FoodRequest> getAllFoodRequestsOrderByOccation(String category);
	public String getRequestId(String requestId,String category);
	public Boolean deleteRequest(String requestId,String category);
	
}
