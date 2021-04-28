package com.example.demo.Dao;

import com.example.demo.Model.User;

public interface RegistrationDao {

	/*interface providing the methods to be implemented in DaoIMPL*/
	public User insertUser(User u);
	public String getUserName(String User_id);
	
}
