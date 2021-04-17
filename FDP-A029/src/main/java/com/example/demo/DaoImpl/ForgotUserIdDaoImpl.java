package com.example.demo.DaoImpl;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.ForgotUserIdDao;
import com.example.demo.Model.User;

@Component
public class ForgotUserIdDaoImpl implements ForgotUserIdDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String checkUserid(String contactno, String email, String sq1, String sq2, String sq3) {
		try {
			String U_id=(String)jdbcTemplate.queryForObject("select user_id from Users where (Contact_no=? and Email=?)and(sq1=? and sq2=? and sq3=?)",new Object[] {contactno,email,sq1,sq2,sq3},String.class);
			return U_id;
			}catch(Exception e) {
				return null;
			}
		
		// TODO Auto-generated method stub
		
	}
	
	
}
