package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.Ticket;
import com.example.demo.Model.User;

public interface HelpDao {
	/* Interface providing all the methods to be implemented in DaoImplementation.*/
	public Ticket insertTicket(Ticket ticket);
	public List<Ticket> getAllRequests();
	public boolean updateTicket(Ticket ticket);
}	
