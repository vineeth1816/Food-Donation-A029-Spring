package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.AdminRequestsDaoImpl;
import com.example.demo.Model.FoodRequest;

@Service
public class AdminRequestsService {

	@Autowired
	AdminRequestsDaoImpl adminRequestsDaoImpl;
	
	public List<FoodRequest> getAllFoodRequests(String category){
		return adminRequestsDaoImpl.getAllFoodRequests(category);
	}
}
