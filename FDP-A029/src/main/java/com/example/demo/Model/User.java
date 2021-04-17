package com.example.demo.Model;

import java.util.Date;

public class User {
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String emailId;
	private String contactNo;
	private String userCategory;
	private String userId;
	private String password;
	private String sq1;
	private String sq2;
	private String sq3;
	public String getFirstName() {
		return firstName;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender
				+ ", emailId=" + emailId + ", contactNo=" + contactNo + ", userCategory=" + userCategory + ", userId="
				+ userId + ", password=" + password + ", sq1=" + sq1 + ", sq2=" + sq2 + ", sq3=" + sq3 + "]";
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getUserCategory() {
		return userCategory;
	}
	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSq1() {
		return sq1;
	}
	public void setSq1(String sq1) {
		this.sq1 = sq1;
	}
	public String getSq2() {
		return sq2;
	}
	public void setSq2(String sq2) {
		this.sq2 = sq2;
	}
	public String getSq3() {
		return sq3;
	}
	public void setSq3(String sq3) {
		this.sq3 = sq3;
	}
		
}
