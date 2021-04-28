package com.example.demo.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.ValidateForgotPasswordDao;
import com.example.demo.Model.User;

@Component
public class ValidateForgotPasswordDaoImpl implements ValidateForgotPasswordDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*
	 * method used to get details of a particular user for validating.
	 */

	@Override
	public User getUser(String userId) {
		
		User user=jdbcTemplate.query("select * from Users where User_ID=?", new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				User u=new User();
				u.setUserId(rs.getString("User_ID"));
				u.setSq1(rs.getString("sq1"));
				u.setSq2(rs.getString("sq2"));
				u.setSq3(rs.getString("sq3"));
				return u;
			}
			
		}, userId);
		return user;
		
		
	}

	

}
