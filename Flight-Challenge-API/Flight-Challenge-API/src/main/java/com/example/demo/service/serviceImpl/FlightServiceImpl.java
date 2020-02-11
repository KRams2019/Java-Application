package com.example.demo.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.demo.dto.FlightDto;

import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightService;

@Service
public class FlightServiceImpl  implements FlightService{

	ModelMapper modelMapper=new ModelMapper();
	
	
	@Autowired
	FlightRepository flightRepository;
	
	
	@Override
	public List<FlightDto> getFlight() {
		
		List<Flight> flightList=flightRepository.findAll();
		List<FlightDto> flightDtoList=flightList.stream().map(entity->convertEntityToDto(entity)).collect(Collectors.toList());
		return flightDtoList;
		
	}
	
	
	public FlightDto convertEntityToDto(Flight flight)
	{
		return modelMapper.map(flight,FlightDto.class);

	}
	
	public Flight convertDtoToEntity(FlightDto flightDto)
	{
		return modelMapper.map(flightDto,Flight.class);
	}

}
