package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.dto.FlightDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.FlightService;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin
public class FlightApplicationController {

	@Autowired
	UserService userService;
	
	@Autowired
	FlightService flightService;
	
	@PostMapping("adduser/{flightId}")
	public ResponseEntity<ApiResponse> addUser(@RequestBody UserDto userDto,@PathVariable int flightId) throws ServiceException {
		UserDto savedUserDto= userService.addUser(userDto, flightId);
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Adding User", false, savedUserDto, HttpStatus.OK), HttpStatus.OK);

	}
	
	@GetMapping("getFlight")
	public ResponseEntity<ApiResponse> getFlights()
	{
		List<FlightDto> flightDtoList= flightService.getFlight();
		
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Get Flight Result", false, flightDtoList, HttpStatus.OK), HttpStatus.OK);

	}
	
	@GetMapping("getUserByFlight/{flightName}")
	public ResponseEntity<ApiResponse> getUserbyFlight(@PathVariable String flightName) throws ServiceException
	{
		List<UserDto> userDtoList= userService.getUserByFlight(flightName);
		
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Get Flight Result", false, userDtoList, HttpStatus.OK), HttpStatus.OK);

	}
	
	
}
