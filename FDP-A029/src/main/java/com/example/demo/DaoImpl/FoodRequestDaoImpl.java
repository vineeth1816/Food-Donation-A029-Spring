package com.example.demo.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.FoodRequestDao;
import com.example.demo.Model.FoodRequest;

@Component
public class FoodRequestDaoImpl implements FoodRequestDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public FoodRequest insertFoodRequest(FoodRequest foodRequest) {
		int flag;
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		try {
			flag=jdbcTemplate.update("INSERT INTO Food_Requests(User_ID,Name,Location,Contact_No,Occation,No_Of_Packets,Status,date) values(?,?,?,?,?,?,?,?)", foodRequest.getUserId(),foodRequest.getName(),foodRequest.getLocation(),foodRequest.getContactNo(),foodRequest.getOccation(),foodRequest.getNoOfPackets(),"Pending for Approval",sqlDate);
			if(flag>0) {
				return foodRequest;
			}
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
	}


	@Override
	public List<FoodRequest> getAllFoodRequests() {
		List<FoodRequest> foodRequests=jdbcTemplate.query("select * from Food_Requests", new RowMapper<FoodRequest>() {

			@Override
			public FoodRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodRequest fr=new FoodRequest();
				fr.setRequestId(rs.getString("Request_ID"));
				fr.setUserId(rs.getString("User_ID"));
				fr.setName(rs.getString("Name"));
				fr.setLocation(rs.getString("Location"));
				fr.setContactNo(rs.getString("Contact_No"));
				fr.setOccation(rs.getString("Occation"));
				fr.setNoOfPackets(rs.getInt("No_Of_Packets"));
				fr.setStatus(rs.getString("Status"));
				fr.setDate(rs.getDate("date"));
				return fr;
			}
			
		});
		return foodRequests;
	}

	@Override
	public List<FoodRequest> getFoodRequestsById(String userId) {
		List<FoodRequest> foodRequests=jdbcTemplate.query("select * from Food_Requests where User_ID=?", new RowMapper<FoodRequest>() {

			@Override
			public FoodRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodRequest fdr=new FoodRequest();
				fdr.setRequestId(rs.getString("Request_ID"));
				fdr.setUserId(rs.getString("User_ID"));
				fdr.setName(rs.getString("Name"));
				fdr.setLocation(rs.getString("Location"));
				fdr.setContactNo(rs.getString("Contact_No"));
				fdr.setOccation(rs.getString("Occation"));
				fdr.setNoOfPackets(rs.getInt("No_Of_Packets"));
				fdr.setStatus(rs.getString("Status"));
				fdr.setDate(rs.getDate("date"));
				return fdr;
			}
			
		},userId);
		return foodRequests;
		
	}


	@Override
	public Boolean updateStatus(String requestId, String status) {
int flag;
		
		try {
			flag=jdbcTemplate.update("UPDATE Food_Requests SET Status=? WHERE Request_ID=?" , status,requestId);
			if(flag>0) {
				return true;
				
			}
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}


	@Override
	public Boolean insertAdminRequest(String requestId, String category) {
		
		int flag;
		try {
		flag=jdbcTemplate.update("insert into Admin_Requests values(?,?)", requestId,category);
		if(flag>0) {
			return true;
		}
		return false;
		}
		catch (Exception e) {
			return false;
		}
	}

}
