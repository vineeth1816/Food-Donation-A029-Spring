package com.example.demo.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.AdminRequestsDao;
import com.example.demo.Model.FoodRequest;
import com.example.demo.Model.LogisticRequest;

@Component
public class AdminRequestsDaoImpl implements AdminRequestsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*
	 * Method retrieving the data from the Database,
	 * selecting the details of request id based upon the 
	 * request d in admin and the required category.
	 */

	@Override
	public List<FoodRequest> getAllFoodRequests(String category) {
		List<FoodRequest> foodRequests=new ArrayList<FoodRequest>();
		foodRequests=jdbcTemplate.query("SELECT * FROM Food_Requests  WHERE Request_ID IN(SELECT RequestId FROM Admin_Requests  WHERE Category=?)",new RowMapper<FoodRequest>() {

			@Override
			public FoodRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodRequest f=new FoodRequest();
				f.setLocation(rs.getString("Location"));
				f.setRequestId(rs.getString("Request_ID"));
				f.setNoOfPackets(rs.getInt("No_Of_Packets"));
				f.setDate(rs.getDate("Date"));
				f.setName(rs.getString("Name"));
				f.setOccation(rs.getString("Occation"));
				return f;
			}
			
		},category);
		
		return foodRequests;
	}
	
	@Override
	public List<LogisticRequest> getAllLogisticRequests(String category) {
		List<LogisticRequest> logisticRequests=new ArrayList<LogisticRequest>();
		logisticRequests=jdbcTemplate.query("SELECT * FROM Logistic_Requests  WHERE request_Id IN(SELECT RequestId FROM Admin_Requests  WHERE Category=?)",new RowMapper<LogisticRequest>() {

			@Override
			public LogisticRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				LogisticRequest f=new LogisticRequest();
				f.setLocation(rs.getString("Location"));
				f.setRequestId(rs.getString("request_Id"));
				f.setContactNo(rs.getString("contactNo"));
				f.setPurpose(rs.getString("purpose"));
				return f;
			}
			
		},category);
		
		return logisticRequests;
	}
	/*
	 * This method is used for retrieving the request id from
	 * Admin_Request table in database based on category and request id.
	 */

	@Override
	public String getRequestId(String requestId, String category) {
		String rId;
		rId=jdbcTemplate.query("select * from Admin_Requests where RequestId=? and Category=?", new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
				return rs.getString("RequestId");
				return null;
			}
			
		}, requestId,category);
		
		return rId;
	}

	/*
	 * This method is used to delete the request ID in 
	 * Admin request table based on category.
	 */
	@Override
	public Boolean deleteRequest(String requestId, String category) {
		int flag;
		try {
		flag=jdbcTemplate.update("DELETE FROM Admin_Requests WHERE RequestId=? and Category=?", requestId,category);
		if(flag>0)
			return true;
		return false;
		}
		catch (Exception e) {
			return false;
		}
	}
	/*
	 * This method is used to get details of 
	 * Request id which are present in admin request table
	 * and get their details present in food_request table.
	 */

	@Override
	public List<FoodRequest> getAllFoodRequestsOrderByLocation(String category) {
		List<FoodRequest> foodRequests=new ArrayList<FoodRequest>();
		foodRequests=jdbcTemplate.query("SELECT * FROM Food_Requests  WHERE Request_ID IN(SELECT RequestId FROM Admin_Requests  WHERE Category=?) order by Location",new RowMapper<FoodRequest>() {

			@Override
			public FoodRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodRequest f=new FoodRequest();
				f.setLocation(rs.getString("Location"));
				f.setRequestId(rs.getString("Request_ID"));
				f.setNoOfPackets(rs.getInt("No_Of_Packets"));
				f.setName(rs.getString("Name"));
				f.setDate(rs.getDate("Date"));
				f.setOccation(rs.getString("Occation"));
				return f;
			}
			
		},category);
		
		return foodRequests;
		
		
	}
	/*
	 This method is used to get details of 
	 * Request id which are present in admin request table
	 * and get their details present in food_request table and sorted 
	 * based on Quantity.
	 */

	@Override
	public List<FoodRequest> getAllFoodRequestsOrderByQuantity(String category) {
		List<FoodRequest> foodRequests=new ArrayList<FoodRequest>();
		foodRequests=jdbcTemplate.query("SELECT * FROM Food_Requests  WHERE Request_ID IN(SELECT RequestId FROM Admin_Requests  WHERE Category=?) order by No_Of_Packets",new RowMapper<FoodRequest>() {

			@Override
			public FoodRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodRequest f=new FoodRequest();
				f.setLocation(rs.getString("Location"));
				f.setRequestId(rs.getString("Request_ID"));
				f.setNoOfPackets(rs.getInt("No_Of_Packets"));
				f.setName(rs.getString("Name"));
				f.setDate(rs.getDate("Date"));
				f.setOccation(rs.getString("Occation"));
				return f;
			}
			
		},category);
		
		return foodRequests;
		
	}
	/*
	 This method is used to get details of 
	 * Request id which are present in admin request table
	 * and get their details present in food_request table and sorted 
	 * based on Occasion.
	 */
	

	@Override
	public List<FoodRequest> getAllFoodRequestsOrderByOccation(String category) {
		List<FoodRequest> foodRequests=new ArrayList<FoodRequest>();
		foodRequests=jdbcTemplate.query("SELECT * FROM Food_Requests  WHERE Request_ID IN(SELECT RequestId FROM Admin_Requests  WHERE Category=?) order by Occation",new RowMapper<FoodRequest>() {

			@Override
			public FoodRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodRequest f=new FoodRequest();
				f.setLocation(rs.getString("Location"));
				f.setRequestId(rs.getString("Request_ID"));
				f.setNoOfPackets(rs.getInt("No_Of_Packets"));
				f.setName(rs.getString("Name"));
				f.setDate(rs.getDate("Date"));
				f.setOccation(rs.getString("Occation"));
				return f;
			}
			
		},category);
		
		return foodRequests;
	}
	/*
	 This method is used to get details of 
	 * Request id which are present in admin request table
	 * and get their details present in food_request table and sorted 
	 * based on Date.
	 */

	@Override
	public List<FoodRequest> getAllFoodRequestsOrderByDate(String category) {
		List<FoodRequest> foodRequests=new ArrayList<FoodRequest>();
		foodRequests=jdbcTemplate.query("SELECT * FROM Food_Requests  WHERE Request_ID IN(SELECT RequestId FROM Admin_Requests  WHERE Category=?) order by Date",new RowMapper<FoodRequest>() {

			@Override
			public FoodRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodRequest f=new FoodRequest();
				f.setLocation(rs.getString("Location"));
				f.setRequestId(rs.getString("Request_ID"));
				f.setNoOfPackets(rs.getInt("No_Of_Packets"));
				f.setName(rs.getString("Name"));
				f.setDate(rs.getDate("Date"));
				f.setOccation(rs.getString("Occation"));
				return f;
			}
			
		},category);
		
		return foodRequests;
	}
	
	

}
