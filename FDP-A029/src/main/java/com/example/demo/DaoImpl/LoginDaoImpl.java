package com.example.demo.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.LoginDao;
import com.example.demo.Model.User;

@Component
public class LoginDaoImpl implements LoginDao{
		
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*
	 * method to get the password for particular user_id from Database.
	 */

	@Override
	public String getPassword(String userId) {
		
		try {
		String password=(String)jdbcTemplate.queryForObject("select Password from users where User_ID=?",new Object[] {userId},String.class);
		return password;
		}catch(Exception e) {
			return null;
		}
	}
	
	/*
	 * method used to retrieve username of an user.
	 */

	@Override
	public String getUserId(String userId) {
		
		try {
		String uid=(String)jdbcTemplate.queryForObject("select User_Id from users where User_ID=?",new Object[] {userId},String.class);
		return uid;
		}catch(Exception e) {
			return null;
		}
		}
	/*
	 * method to retrieve details of a particular user.
	 */
	
	

	@Override
	public User getUser(String user_id) {
		User user=jdbcTemplate.query("SELECT * FROM users where User_ID=?", new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				User u=new User();
				u.setContactNo(rs.getString("Contact_no"));
				u.setFirstName(rs.getString("First_name"));
				u.setLastName(rs.getString("Last_name"));
				u.setUserCategory(rs.getString("User_category"));
				return u;
			}
			
		}, user_id);
		System.out.println(user);
		return user;
	}
	
	
	
}
