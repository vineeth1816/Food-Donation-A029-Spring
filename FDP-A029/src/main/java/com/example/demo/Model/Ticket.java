package com.example.demo.Model;

import java.util.Date;

public class Ticket {

   String requestId;
   String userId;
   String issue;
   String description;
   Date date;
   String status;
   String resolution;
public String getResolution() {
	return resolution;
}
public void setResolution(String resolution) {
	this.resolution = resolution;
}
public String getRequestId() {
	return requestId;
}
public void setRequestId(String requestId) {
	this.requestId = requestId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getIssue() {
	return issue;
}
public void setIssue(String issue) {
	this.issue = issue;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
   
}
