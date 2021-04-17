package com.example.demo.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.LoginDao;

@Component
public class LoginDaoImpl implements LoginDao{
		
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String getPassword(String userId) {
		// TODO Auto-generated method stub
		try {
		String password=(String)jdbcTemplate.queryForObject("select Password from users where User_ID=?",new Object[] {userId},String.class);
		return password;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public String getUserId(String userId) {
		// TODO Auto-generated method stub
		try {
		String uid=(String)jdbcTemplate.queryForObject("select User_Id from users where User_ID=?",new Object[] {userId},String.class);
		return uid;
		}catch(Exception e) {
			return null;
		}
		}
	
	
	
}
