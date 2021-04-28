package com.example.demo.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.LogisticsDao;
import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.Vehicle;
@Component
public class LogisticsDaoImpl implements LogisticsDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*
	 * method used to add Logistics details in Database.
	 */

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
	
	/*
	 * Method used to find the Available vehicles of that particular location.
	 */

	@Override
	public List<Vehicle> getAllRequests(String donationId) {
		List<Vehicle> vehicles=jdbcTemplate.query("select * from Logistics where Location in (select Location from Food_Donation_Requests where Donation_ID=?)", new RowMapper<Vehicle>() {

			@Override
			public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
				Vehicle fdr=new Vehicle();
				fdr.setVehicleNo(rs.getString("Vehicle_no"));
				fdr.setDriverName(rs.getString("Driver_Name"));
				fdr.setLocation(rs.getString("Location"));
				fdr.setStatus(rs.getString("Status"));
				return fdr;
			}
			
		},donationId);
		return vehicles;
	}
	
	/*
	 * method used to update the status of vehicle in logistics and 
	 * corresponding donar request status and food request status in 
	 * food_donation_requests and food_requests respectively in database.
	 */
	
	@Override
	public boolean updateVehicle(String Vehicleno,String donationId,String requestId) {
		
		 
	
		int i=jdbcTemplate.update("Update Mapped_Requests set Logistics_id=?,Status='Logistics Assigned' where Donation_Id=?",Vehicleno,donationId);
		if(i>0)
		i=jdbcTemplate.update("Update Logistics set Status='Busy' where Vehicle_no=?",Vehicleno);
		if(i>0)
		i=jdbcTemplate.update("Update food_donation_requests set Status='Logistics Assigned' where Donation_ID=?",donationId);
		if(i>0)
		i=jdbcTemplate.update("Update food_requests set Status='Logistics Assigned' where Request_ID=?",requestId);
		if(i>0)
		return true;
		
		return false;
		
	
		
		// TODO Auto-generated method stub
		
	}

}
