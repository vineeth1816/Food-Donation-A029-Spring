package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.FoodRequest;

public interface AdminRequestsDao {

	public List<FoodRequest> getAllFoodRequests(String category);
}
