package com.example.demo.Model;

public class Vehicle {
	private String vehicleNo;
	private String driverName;
	private String location;
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleNo=" + vehicleNo + ", driverName=" + driverName + ", location=" + location + "]";
	}
	
	
	
}
