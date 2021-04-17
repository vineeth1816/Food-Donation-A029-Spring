package com.example.demo.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.setPasswordDao;
import com.example.demo.Model.User;

@Component
public class setPasswordDaoImpl implements setPasswordDao{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean updatePassword(User user) {
		int flag;
		flag=jdbcTemplate.update("UPDATE users SET Password=? WHERE User_ID=?",user.getPassword(),user.getUserId());
		if(flag>0)
			return true;
		return false;
	}

}
