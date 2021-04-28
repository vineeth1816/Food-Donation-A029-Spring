package com.example.demo.Dao;

import com.example.demo.Model.User;

public interface LoginDao {
	/* Interface providing all the methods to be implemented in DaoImplementation.*/
	public String getPassword(String userId);
	public String getUserId(String userId);
	public User getUser(String user_id);

}
