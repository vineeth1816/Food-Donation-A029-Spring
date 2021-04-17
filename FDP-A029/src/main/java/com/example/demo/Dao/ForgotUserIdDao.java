package com.example.demo.Dao;

import com.example.demo.Model.User;

public interface ForgotUserIdDao {
	
	public String  checkUserid(String contactno,String email,String sq1,String sq2,String sq3);

}
