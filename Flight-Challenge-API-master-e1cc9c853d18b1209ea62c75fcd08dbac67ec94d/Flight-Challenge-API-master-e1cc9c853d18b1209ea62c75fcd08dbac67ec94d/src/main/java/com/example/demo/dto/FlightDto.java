package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class FlightDto {

	private int flightId;
	private String flightName;
	
	@JsonIgnoreProperties("flight")
	private List<UserDto> users;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}
	
	
	
}

