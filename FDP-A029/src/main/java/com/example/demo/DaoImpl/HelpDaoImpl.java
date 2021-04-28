package com.example.demo.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.HelpDao;
import com.example.demo.Dao.LoginDao;
import com.example.demo.Model.FoodRequest;
import com.example.demo.Model.Ticket;
import com.example.demo.Model.User;

@Component
public class HelpDaoImpl implements HelpDao{
		
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Ticket insertTicket(Ticket ticket) {
		// TODO Auto-generated method stub

		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		int i=jdbcTemplate.update("INSERT INTO Tickets(userId,issue,description,date,status) VALUES(?,?,?,?,?)",ticket.getUserId(),ticket.getIssue(),ticket.getDescription(),sqlDate,"Pending");
		if(i>0)
		return ticket;
		else
		return null;
	}

	@Override
	public List<Ticket> getAllRequests() {
		// TODO Auto-generated method stub
		
			List<Ticket> tickets=jdbcTemplate.query("select * from Tickets", new RowMapper<Ticket>() {

				@Override
				public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
					Ticket fr=new Ticket();
					fr.setRequestId(rs.getString("requestId"));
					fr.setUserId(rs.getString("userId"));
					fr.setDate(rs.getDate("date"));
					fr.setDescription(rs.getString("description"));
					fr.setIssue(rs.getString("issue"));
					fr.setStatus(rs.getString("status"));
					fr.setResolution(rs.getString("resolution"));
					return fr;
				}
				
			});
			return tickets;
		
		
	}

	@Override
	public boolean updateTicket(Ticket ticket) {
		int i=jdbcTemplate.update("update Tickets set resolution=?,status='Resolved' where requestId=?",ticket.getResolution(),ticket.getRequestId());
		if(i>0)
		return true;
		
		return false;
	}
	
	

	
	

	
}
