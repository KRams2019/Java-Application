package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.ServiceException;

public interface UserService {
	
	public UserDto addUser(UserDto userDto,int flightId) throws ServiceException;
	
	public List<UserDto> getUserByFlight(String flightName) throws ServiceException;

}
