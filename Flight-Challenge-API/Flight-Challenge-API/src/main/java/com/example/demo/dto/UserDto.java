package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserDto {
	
	private int userId;
	
	private String userName;
	
	private int age;
	
	@JsonIgnoreProperties("users")
	private FlightDto flight;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public FlightDto getFlight() {
		return flight;
	}

	public void setFlight(FlightDto flight) {
		this.flight = flight;
	}
	
	
	
	

}
