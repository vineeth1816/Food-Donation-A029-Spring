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
	
	
	public Boolean checkRequestId(String requestId,String category) {
		String rid=adminRequestsDaoImpl.getRequestId(requestId, category);
		if(rid!=null) {
			return true;
		}
		return false;
	}
	
	
	public Boolean deleteRequest(String requestId,String category) {
		return adminRequestsDaoImpl.deleteRequest(requestId, category);
	}
}
