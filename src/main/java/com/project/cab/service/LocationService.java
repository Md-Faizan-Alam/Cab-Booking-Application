package com.project.cab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Location;
import com.project.cab.repository.LocationRepository;

@Service
public class LocationService {
	@Autowired
	LocationRepository repository;
	
	public float getDistance(String fromLocation,String toLocation) {
		List<Location> locationList = repository.findAll();
		int to = 0 ,from = 0;
		for(int i=0;i<locationList.size();i++) {
			if(locationList.get(i).getName().equals(toLocation)) {
				to = i;
			}
			if(locationList.get(i).getName().equals(fromLocation)) {
				from = i;
			}
		}
		return (float)(2*Math.abs(from-to));
	}
	
	public List<Location> getAllLocations(){
		return repository.findAll();
	}
}
