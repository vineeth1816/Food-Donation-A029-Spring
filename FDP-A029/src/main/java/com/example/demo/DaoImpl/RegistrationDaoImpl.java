package com.example.demo.DaoImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.RegistrationDao;
import com.example.demo.Model.User;
@Component
public class RegistrationDaoImpl implements RegistrationDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
    
	
	
	@Override
	public User insertUser(User u) {

		int i=jdbcTemplate.update("INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",u.getUserId(),u.getFirstName(),u.getLastName(),u.getDob(),u.getGender(),u.getContactNo(),u.getPassword(),u.getUserCategory(),u.getSq1(),u.getSq2(),u.getSq3(),u.getEmailId());
		if(i>0)
		return u;
		else
		return null;
	}

	
	@Override
	public String getUserName(String User_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
