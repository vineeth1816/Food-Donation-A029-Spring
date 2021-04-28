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
import com.example.demo.Model.FoodDonationRequest;

@Component
public class FoodDonationDaoImpl implements FoodDonationDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*
	 * Method inserting Food donar  details into the Database.
	 */

	@Override
	public FoodDonationRequest insertRequest(FoodDonationRequest foodDonationRequest) {
		int flag;
		try {
			flag=jdbcTemplate.update("INSERT INTO Food_Donation_Requests(User_ID,Name,Location,Contact_No,Purpose,No_Of_Packets,Status) values(?,?,?,?,?,?,?)", foodDonationRequest.getUserId(),foodDonationRequest.getName(),foodDonationRequest.getLocation(),foodDonationRequest.getContactNo(),foodDonationRequest.getPurpose(),foodDonationRequest.getNoOfPackets(),"Pending for Approval");
			if(flag>0) {
				return foodDonationRequest;
			}
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
	}
	
	/*
	 * Method used to getdetails of all the registered food donars from
	 * Database.
	 */

	@Override
	public List<FoodDonationRequest> getAllRequests() {
		List<FoodDonationRequest> foodDonationRequests=jdbcTemplate.query("select * from Food_Donation_Requests", new RowMapper<FoodDonationRequest>() {

			@Override
			public FoodDonationRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodDonationRequest fdr=new FoodDonationRequest();
				fdr.setDonationId(rs.getString("Donation_ID"));
				fdr.setUserId(rs.getString("User_ID"));
				fdr.setName(rs.getString("Name"));
				fdr.setLocation(rs.getString("Location"));
				fdr.setContactNo(rs.getString("Contact_No"));
				fdr.setPurpose(rs.getString("Purpose"));
				fdr.setNoOfPackets(rs.getInt("No_Of_Packets"));
				fdr.setStatus(rs.getString("Status"));
				return fdr;
			}
			
		});
		return foodDonationRequests;
	}
	
	/*
	 * method used to retrieve details of all the donars whose requests are approved.
	 */
	
	@Override
	public List<FoodDonationRequest> getAllApprovedRequests() {
		List<FoodDonationRequest> foodDonationRequests=jdbcTemplate.query("select * from Food_Donation_Requests where Status='Approved'", new RowMapper<FoodDonationRequest>() {

			@Override
			public FoodDonationRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodDonationRequest fdr=new FoodDonationRequest();
				fdr.setDonationId(rs.getString("Donation_ID"));
				fdr.setUserId(rs.getString("User_ID"));
				fdr.setName(rs.getString("Name"));
				fdr.setLocation(rs.getString("Location"));
				fdr.setContactNo(rs.getString("Contact_No"));
				fdr.setPurpose(rs.getString("Purpose"));
				fdr.setNoOfPackets(rs.getInt("No_Of_Packets"));
				fdr.setStatus(rs.getString("Status"));
				return fdr;
			}
			
		});
		return foodDonationRequests;
	}
	
	/*
	 * method to rerieve the details of donar based upon user_id.
	 */

	@Override
	public List<FoodDonationRequest> getRequestsById(String userId) {
		List<FoodDonationRequest> foodDonationRequests=jdbcTemplate.query("select * from Food_Donation_Requests where User_ID=? order by Donation_ID desc", new RowMapper<FoodDonationRequest>() {

			@Override
			public FoodDonationRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodDonationRequest fdr=new FoodDonationRequest();
				fdr.setDonationId(rs.getString("Donation_ID"));
				fdr.setUserId(rs.getString("User_ID"));
				fdr.setName(rs.getString("Name"));
				fdr.setLocation(rs.getString("Location"));
				fdr.setContactNo(rs.getString("Contact_No"));
				fdr.setPurpose(rs.getString("Purpose"));
				fdr.setNoOfPackets(rs.getInt("No_Of_Packets"));
				fdr.setStatus(rs.getString("Status"));
				return fdr;
			}
			
		},userId);
		return foodDonationRequests;
		
	}
	
	/*
	 * Method used to update the status of the particular request. 
	 */

	@Override
	public Boolean updateStatus(String donationId,String status) {
		int flag;
		
		try {
			flag=jdbcTemplate.update("UPDATE Food_Donation_Requests SET Status=? WHERE Donation_ID=?" , status,donationId);
			if(flag>0) {
				return true;
				
			}
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}
	
	/*
	 * method used to know the status of particular donation request.
	 */
	

	@Override
	public String getStatus(String donationId) {
		String s;
		s=jdbcTemplate.query("select * from Food_Donation_Requests WHERE Donation_ID=?",new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				
				return rs.getString("Status");
			}
			
		},donationId);
		return s;
	}
	

}
