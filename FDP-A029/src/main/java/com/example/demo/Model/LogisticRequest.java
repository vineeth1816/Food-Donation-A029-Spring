package com.example.demo.Model;

public class LogisticRequest {

	private String requestId;
	private String location;
	private String contactNo;
	private String purpose;
	private String status;
	
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
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	@Override
	public String toString() {
		return "LogisticRequest [requestId=" + requestId + ", location=" + location + ", contactNo=" + contactNo
				+ ", purpose=" + purpose + ", status=" + status + "]";
	}
}
