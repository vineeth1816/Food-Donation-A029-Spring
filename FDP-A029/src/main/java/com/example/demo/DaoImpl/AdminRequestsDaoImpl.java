package com.example.demo.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.AdminRequestsDao;
import com.example.demo.Model.FoodRequest;

@Component
public class AdminRequestsDaoImpl implements AdminRequestsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

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
				f.setOccation(rs.getString("Occation"));
				return f;
			}
			
		},category);
		
		return foodRequests;
	}

}
