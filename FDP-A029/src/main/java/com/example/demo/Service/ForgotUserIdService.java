package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.ForgotUserIdDao;

import com.example.demo.Model.User;

@Service
public class ForgotUserIdService {
	@Autowired
	ForgotUserIdDao forgotUserIdDao;
	
	/*
	 * Service Method calling the CheckUserid method in DaoIMPL class.
	 */
	
	public User userIdRecovery(User user ) {
		User u1=new User();
		String u_id =forgotUserIdDao.checkUserid(user.getContactNo(),user.getEmailId(),user.getSq1(),user.getSq2(),user.getSq3());
		if(u_id==null) {
			return u1;
		}
		else {
			u1.setUserId(u_id);
			return u1;
		}
	}

}
