package com.example.demo.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.MappingDao;
import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.FoodRequest;

@Component
public class MappingDaoImpl implements MappingDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Boolean mapRequestDonor(String requestID, String donorID) {
		int flag;
		flag=jdbcTemplate.update("insert into Mapped_Requests(Donation_Id,Request_Id,Status) values(?,?,?)",donorID, requestID,"Pending for logistics Assignment");
		if(flag>0)
			return true;
		else
			return false;
	}

}
