package com.project.cab.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Driver;
import com.project.cab.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository repository;
	@Autowired
	TripBookingService tripService;
	
	public void insertDriver(Driver driver) {
		repository.save(driver);
	}
	
	public void updateDriver(Driver driver) {
		repository.save(driver);
	}
	
	public void deleteDriver(Driver driver) {
		repository.save(driver);
	}
	
	public List<Driver> viewBestDrivers(){
		List<Driver> bestDriver = repository.findAll();
		bestDriver = bestDriver.stream().filter(driver -> driver.getRating()>=4.5).collect(Collectors.toList());
		return bestDriver;
	}
	
	public Driver viewDriver(int driverId){
		List<Driver> driverList = repository.findAll();
		for(Driver driver:driverList) {
			if(driver.getUserId()==driverId) {
				return driver;
			}
		}
		return null;
	}
	public Driver viewDriver(String userName){
		List<Driver> driverList = repository.findAll();
		for(Driver driver:driverList) {
			if(driver.getUsername().equals(userName)) {
				return driver;
			}
		}
		return null;
	}
	public boolean validateDriver(String userName,String password,String type) {
		if(type.equals("D")) {
			List<Driver> driverList = repository.findAll();
			for(Driver driver:driverList) {
				if(driver.getEmail().equalsIgnoreCase(userName) || driver.getUsername().equalsIgnoreCase(userName)) {
					if(driver.getPassword().equals(password)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public List<Driver> viewDriversWithCarType(String carType){
		List<Driver> driverList = repository.findAll();
		if(carType.equals("All")) {
			return driverList;
		}
		driverList = driverList.stream().filter(driver -> driver.getCab().getCarType().equals(carType)).collect(Collectors.toList());
		return driverList;
	}
	
	public void updateRating(int driverId,int rating) {
		Driver driver = viewDriver(driverId);
		float oldRating = driver.getRating();
		float noOfTrips = tripService.getNoOfTrips(driverId);
		float newRating =  ((oldRating*(noOfTrips-1))+(float)rating)/(noOfTrips);
		driver.setRating(newRating);
		updateDriver(driver);
	}
}
