package com.example.demo.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.MappingDao;
import com.example.demo.Model.FoodDonationRequest;
import com.example.demo.Model.FoodRequest;
import com.example.demo.Model.LogisticDonationRequest;
import com.example.demo.Model.MappedRequests;

@Component
public class MappingDaoImpl implements MappingDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Boolean mapRequestDonor(String requestID, String donorID) {
		System.out.println(requestID+"  "+donorID);
		int flag;
		flag=jdbcTemplate.update("insert into Mapped_Requests(Donation_Id,Request_Id,Status,Logistics_id) values(?,?,?,?)",donorID,requestID,"Pending for logistics Assignment","NA");
		if(flag>0)
			return true;
		else
			return false;
	}
	
	@Override
	public List<MappedRequests> getAllRequests() {
		List<MappedRequests> mappedRequests=jdbcTemplate.query("select * from Mapped_Requests", new RowMapper<MappedRequests>() {

			@Override
			public MappedRequests mapRow(ResultSet rs, int rowNum) throws SQLException {
				MappedRequests ldr=new MappedRequests();
				ldr.setRequestId(rs.getString("Request_Id"));
				ldr.setDonationId(rs.getString("Donation_Id"));
				ldr.setLogisticId(rs.getString("Logistics_Id"));
				ldr.setStatus(rs.getString("Status"));
				return ldr;
			}
			
		});
		return mappedRequests;
	}

}
