package com.example.demo.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FlightDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Flight;
import com.example.demo.entity.User;
import com.example.demo.exception.FlightNotFoundException;
import com.example.demo.exception.ServiceException;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	ModelMapper modelMapper=new ModelMapper();
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto addUser(UserDto userDto, int flightId) throws ServiceException {
		
		boolean flightExists=flightRepository.existsById(flightId);
		try {
		if(flightExists==true) {
			Flight flight=flightRepository.findById(flightId).get();
			User user=convertDtoToEntity(userDto);
			user.setFlight(flight);
			User savedUser=userRepository.save(user);
			return convertEntityToDto(savedUser);
		}
		else {
			throw new FlightNotFoundException("Flight Not Found");
		}
		}catch(FlightNotFoundException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	
	
	public UserDto convertEntityToDto(User user)
	{
		return modelMapper.map(user,UserDto.class);

	}
	
	public User convertDtoToEntity(UserDto userDto)
	{
		return modelMapper.map(userDto,User.class);
	}


	@Override
	public List<UserDto> getUserByFlight(String flightName) throws ServiceException {
		try {
		boolean result=flightRepository.existsByFlightName(flightName);
		if(result==true) {
			Flight flight=flightRepository.findByFlightName(flightName);
			List<User> userList=flight.getUsers();
			List<UserDto> userDtoList=userList.stream().map(entity->convertEntityToDto(entity)).collect(Collectors.toList());		
		
			return userDtoList;
		}
		else {
			throw new FlightNotFoundException("Flight Not Found!!");
		}}
		catch (FlightNotFoundException e) {
			throw new ServiceException(e.getMessage(),e);
		}

	}
	

}
