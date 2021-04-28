package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.AdminRequestsDaoImpl;
import com.example.demo.Model.FoodRequest;
import com.example.demo.Model.LogisticRequest;

import ch.qos.logback.classic.db.names.ColumnName;

@Service
public class AdminRequestsService {

	@Autowired
	AdminRequestsDaoImpl adminRequestsDaoImpl;
	
	/*
	 * This the service method for 
	 * sorting and retrieving the details based on 
	 * category and sorted according to required fields.
	 */
	
	public List<FoodRequest> getAllFoodRequests(String category){
		return adminRequestsDaoImpl.getAllFoodRequests(category);
	}
	
	public List<LogisticRequest> getAllLogisticRequests(String category){
		
		return adminRequestsDaoImpl.getAllLogisticRequests(category);
	}
	
	public List<FoodRequest> getAllFoodRequestsOrderByColumn(String category,String columnName){
		if(columnName.equals("NoOfPackets"))
			return adminRequestsDaoImpl.getAllFoodRequestsOrderByQuantity(category);
		if(columnName.equals("Date"))
			return adminRequestsDaoImpl.getAllFoodRequestsOrderByDate(category);
		if (columnName.equals("Location"))
			return adminRequestsDaoImpl.getAllFoodRequestsOrderByLocation(category);
		return adminRequestsDaoImpl.getAllFoodRequestsOrderByOccation(category);
	}
	
	/*
	 * This is the service method to get
	 * request_id of admin based on category.
	 */
	
	
	public Boolean checkRequestId(String requestId,String category) {
		String rid=adminRequestsDaoImpl.getRequestId(requestId, category);
		if(rid!=null) {
			return true;
		}
		return false;
	}
	
	/*
	 * This is the service method to delete the request
	 * raised by admin on the basis of category. 
	 */
	public Boolean deleteRequest(String requestId,String category) {
		return adminRequestsDaoImpl.deleteRequest(requestId, category);
	}
}
