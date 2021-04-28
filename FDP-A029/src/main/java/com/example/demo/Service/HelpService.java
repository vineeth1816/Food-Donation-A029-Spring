package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.LoginDao;
import com.example.demo.DaoImpl.HelpDaoImpl;
import com.example.demo.DaoImpl.LoginDaoImpl;
import com.example.demo.Model.Ticket;
import com.example.demo.Model.User;

@Service
public class HelpService {

	
	@Autowired
	HelpDaoImpl helpDaoImpl;
	
	public Ticket insertTicket(Ticket ticket) {
		return helpDaoImpl.insertTicket(ticket);
	}
	
	/*
	 * Service method used to check the user_id and password of the user for authentication.
	 */
	public List<Ticket> getRequests() {
		return helpDaoImpl.getAllRequests();
	}
	
	public boolean updateTicket(Ticket ticket) {
		return helpDaoImpl.updateTicket(ticket);
	}
}
