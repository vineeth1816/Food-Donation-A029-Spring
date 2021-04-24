package com.example.demo.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.LogisticsDao;
@Component
public class LogisticsDaoImpl implements LogisticsDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Boolean addVehicle(String Vehicleno, String Drivername, String Location) {
		
		 boolean flag=true;
		 String status="Available";
		int i=jdbcTemplate.update("INSERT INTO logistics VALUES(?,?,?,?)",Vehicleno,Drivername,Location,status);
		if(i>0)
		return flag;
		else
		return flag=false;
		
		// TODO Auto-generated method stub
		
	}

}
