package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.LoginDao;
import com.example.demo.DaoImpl.LoginDaoImpl;
import com.example.demo.Model.User;

@Service
public class LoginService {

	@Autowired
	LoginDao loginDao;
	
	@Autowired
	LoginDaoImpl loginDaoImpl;
	
	public User loginUser(User user) {
		User us=new User();
		
	
		String userId=loginDao.getUserId(user.getUserId());
		
		if(userId!=null) {
		if(userId.equals(user.getUserId())) 
		{   

		us.setUserId(user.getUserId());	
		String password=loginDao.getPassword(user.getUserId());
		
		if(password.equals(user.getPassword())) {
			
		    
			return user;
			
			
		}
		}
		
		else {

		    System.out.println(us.getUserId());
		    
			return us;
		}
		}
		
		return us;
		
			
		
	    
		
	
		
}
	public User getUser(String user_id) {
		return loginDaoImpl.getUser(user_id);
	}
}
