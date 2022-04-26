package com.project.cab.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Driver;
import com.project.cab.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository repository;
	
	public void insertDriver(Driver driver) {
		repository.save(driver);
	}
	
	public void updateDriver(Driver driver) {
		repository.save(driver);
	}
	
	public void deleteDriver(Driver driver) {
		repository.save(driver);
	}
	
	public Driver viewDriver(int driverId){
		Optional<Driver> driverOptional = (Optional<Driver>) repository.findById(driverId);
		Driver driver = null;
		if(driverOptional.isPresent()) {
			 driver = driverOptional.get();
		}
		return driver;
	}
}
