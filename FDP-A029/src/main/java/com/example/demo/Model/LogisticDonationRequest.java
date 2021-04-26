package com.example.demo.Model;

public class LogisticDonationRequest {

	private String donationId;
	private String userId;
	private String name;
	private String location;
	private String contactNo;
	private String purpose;
	private String status;
	public String getDonationId() {
		return donationId;
	}
	public void setDonationId(String donationId) {
		this.donationId = donationId;
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
	@Override
	public String toString() {
		return "LogisticDonationRequest [donationId=" + donationId + ", userId=" + userId + ", name=" + name
				+ ", location=" + location + ", contactNo=" + contactNo + ", purpose=" + purpose + ", status=" + status
				+ "]";
	}

}
