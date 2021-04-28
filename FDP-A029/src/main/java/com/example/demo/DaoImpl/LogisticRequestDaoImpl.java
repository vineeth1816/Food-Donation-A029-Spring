package com.example.demo.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.FoodDonationDao;
import com.example.demo.Dao.LogisticDonationDao;
import com.example.demo.Dao.LogisticRequestDao;
import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.LogisticDonationRequest;
import com.example.demo.Model.LogisticRequest;

@Component
public class LogisticRequestDaoImpl implements LogisticRequestDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public LogisticRequest insertRequest(LogisticRequest logisticRequest) {
		int flag;
		try {
			flag=jdbcTemplate.update("INSERT INTO Logistic_Requests(location,contactNo,purpose,status) values(?,?,?,?)",logisticRequest.getLocation(),logisticRequest.getContactNo(),logisticRequest.getPurpose(),"Pending for Volunteering");
			if(flag>0) {
				String reqId=jdbcTemplate.queryForObject("select max(request_Id) from Logistic_Requests",new Object[] {},String.class);
				logisticRequest.setRequestId(reqId);
				return logisticRequest;
			}
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
	}

	@Override
	public List<LogisticRequest> getAllRequests() {
		List<LogisticRequest> logisticRequests=jdbcTemplate.query("select * from Logistic_Donation_Requests", new RowMapper<LogisticRequest>() {

			@Override
			public LogisticRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				LogisticRequest lr=new LogisticRequest();
		        lr.setRequestId(rs.getString("request_Id"));
				lr.setLocation(rs.getString("location"));
				lr.setContactNo(rs.getString("contactNo"));
				lr.setPurpose(rs.getString("purpose"));
				lr.setStatus(rs.getString("status"));
				return lr;
			}
			
		});
		return logisticRequests;
	}
//	@Override
//	public List<FoodDonationRequest> getAllApprovedRequests() {
//		List<FoodDonationRequest> foodDonationRequests=jdbcTemplate.query("select * from Food_Donation_Requests where Status='Approved'", new RowMapper<FoodDonationRequest>() {
//
//			@Override
//			public FoodDonationRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
//				FoodDonationRequest fdr=new FoodDonationRequest();
//				fdr.setDonationId(rs.getString("Donation_ID"));
//				fdr.setUserId(rs.getString("User_ID"));
//				fdr.setName(rs.getString("Name"));
//				fdr.setLocation(rs.getString("Location"));
//				fdr.setContactNo(rs.getString("Contact_No"));
//				fdr.setPurpose(rs.getString("Purpose"));
//				fdr.setNoOfPackets(rs.getInt("No_Of_Packets"));
//				fdr.setStatus(rs.getString("Status"));
//				return fdr;
//			}
//			
//		});
//		return foodDonationRequests;
//	}
//
//	@Override
//	public List<FoodDonationRequest> getRequestsById(String userId) {
//		List<FoodDonationRequest> foodDonationRequests=jdbcTemplate.query("select * from Food_Donation_Requests where User_ID=?", new RowMapper<FoodDonationRequest>() {
//
//			@Override
//			public FoodDonationRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
//				FoodDonationRequest fdr=new FoodDonationRequest();
//				fdr.setDonationId(rs.getString("Donation_ID"));
//				fdr.setUserId(rs.getString("User_ID"));
//				fdr.setName(rs.getString("Name"));
//				fdr.setLocation(rs.getString("Location"));
//				fdr.setContactNo(rs.getString("Contact_No"));
//				fdr.setPurpose(rs.getString("Purpose"));
//				fdr.setNoOfPackets(rs.getInt("No_Of_Packets"));
//				fdr.setStatus(rs.getString("Status"));
//				return fdr;
//			}
//			
//		},userId);
//		return foodDonationRequests;
//		
//	}
//
//	@Override
//	public Boolean updateStatus(String donationId,String status) {
//		int flag;
//		
//		try {
//			flag=jdbcTemplate.update("UPDATE Food_Donation_Requests SET Status=? WHERE Donation_ID=?" , status,donationId);
//			if(flag>0) {
//				return true;
//				
//			}
//		}
//		catch (Exception e) {
//			return false;
//		}
//		return false;
//	}
//	
//	
//
//	@Override
//	public String getStatus(String donationId) {
//		String s;
//		s=jdbcTemplate.query("select * from Food_Donation_Requests WHERE Donation_ID=?",new ResultSetExtractor<String>() {
//
//			@Override
//			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
//				rs.next();
//				
//				return rs.getString("Status");
//			}
//			
//		},donationId);
//		return s;
//	}
	

}
