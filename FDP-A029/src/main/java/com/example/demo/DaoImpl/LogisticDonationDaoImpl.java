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
import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.LogisticDonationRequest;

@Component
public class LogisticDonationDaoImpl implements LogisticDonationDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public LogisticDonationRequest insertRequest(LogisticDonationRequest logisticDonationRequest) {
		int flag;
		try {
			flag=jdbcTemplate.update("INSERT INTO Logistic_Donation_Requests(user_Id,name,location,contactNo,purpose,status) values(?,?,?,?,?,?)", logisticDonationRequest.getUserId(),logisticDonationRequest.getName(),logisticDonationRequest.getLocation(),logisticDonationRequest.getContactNo(),logisticDonationRequest.getPurpose(),"Pending for Approval");
			if(flag>0) {
				return logisticDonationRequest;
			}
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
	}

	@Override
	public List<LogisticDonationRequest> getAllRequests() {
		List<LogisticDonationRequest> logisticDonationRequests=jdbcTemplate.query("select * from Logistic_Donation_Requests", new RowMapper<LogisticDonationRequest>() {

			@Override
			public LogisticDonationRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				LogisticDonationRequest ldr=new LogisticDonationRequest();
				ldr.setDonationId(rs.getString("donation_Id"));
				ldr.setUserId(rs.getString("user_Id"));
				ldr.setName(rs.getString("name"));
				ldr.setLocation(rs.getString("location"));
				ldr.setContactNo(rs.getString("contactNo"));
				ldr.setPurpose(rs.getString("purpose"));
				ldr.setStatus(rs.getString("status"));
				return ldr;
			}
			
		});
		return logisticDonationRequests;
	}
	@Override
	public List<LogisticDonationRequest> getAllPendingDonors() {
		List<LogisticDonationRequest> logisticDonationRequests=jdbcTemplate.query("select * from Logistic_Donation_Requests where status='Approved' OR status='Pending for Approval'", new RowMapper<LogisticDonationRequest>() {

			@Override
			public LogisticDonationRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				LogisticDonationRequest fdr=new LogisticDonationRequest();
				fdr.setDonationId(rs.getString("donation_Id"));
				fdr.setUserId(rs.getString("user_Id"));
				fdr.setName(rs.getString("name"));
				fdr.setLocation(rs.getString("location"));
				fdr.setContactNo(rs.getString("contactNo"));
				fdr.setPurpose(rs.getString("purpose"));
				fdr.setStatus(rs.getString("status"));
				return fdr;
			}
			
		});
		return logisticDonationRequests;
	}

	@Override
	public List<LogisticDonationRequest> getRequestsById(String userId) {
		List<LogisticDonationRequest> logisticDonationRequests=jdbcTemplate.query("select * from Logistic_Donation_Requests where user_Id=? order by donation_Id desc", new RowMapper<LogisticDonationRequest>() {

			@Override
			public LogisticDonationRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				LogisticDonationRequest fdr=new LogisticDonationRequest();
				fdr.setDonationId(rs.getString("donation_Id"));
				fdr.setUserId(rs.getString("user_Id"));
				fdr.setName(rs.getString("name"));
				fdr.setLocation(rs.getString("location"));
				fdr.setContactNo(rs.getString("contactNo"));
				fdr.setPurpose(rs.getString("purpose"));
				fdr.setStatus(rs.getString("status"));
				return fdr;
			}
			
		},userId);
		return logisticDonationRequests;
		
	}

	@Override
	public Boolean updateStatus(String donationId,String status) {
		int flag;
		
		try {
			flag=jdbcTemplate.update("UPDATE Logistic_Donation_Requests SET status=? WHERE donation_Id=?" , status,donationId);
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
	public String getStatus(String donationId) {
		String s;
		s=jdbcTemplate.query("select * from Logistic_Donation_Requests WHERE donation_Id=?",new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				
				return rs.getString("Status");
			}
			
		},donationId);
		return s;
	}
	

}
