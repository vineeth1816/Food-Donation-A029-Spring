package com.example.demo.Model;

import java.util.Date;

public class FoodRequest {

	@Override
	public String toString() {
		return "FoodRequest [requestId=" + requestId + ", userId=" + userId + ", name=" + name + ", location="
				+ location + ", contactNo=" + contactNo + ", occation=" + occation + ", noOfPackets=" + noOfPackets
				+ ", status=" + status + ", date=" + date + "]";
	}
	private String requestId;
	private String userId;
	private String name;
	private String location;
	private String contactNo;
	private String occation;
	private int noOfPackets;
	private String status;
	private Date date;
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getOccation() {
		return occation;
	}
	public void setOccation(String occation) {
		this.occation = occation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public int getNoOfPackets() {
		return noOfPackets;
	}
	public void setNoOfPackets(int noOfPackets) {
		this.noOfPackets = noOfPackets;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
