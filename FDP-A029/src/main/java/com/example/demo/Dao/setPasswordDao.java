package com.example.demo.Dao;

import com.example.demo.Model.User;

public interface setPasswordDao {
	
	/*Interface used to provide all the methods to be implemented in daoIMPL.*/

	public boolean updatePassword(User user);
}
