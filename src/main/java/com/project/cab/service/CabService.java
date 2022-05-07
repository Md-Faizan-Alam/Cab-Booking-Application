package com.project.cab.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Cab;
import com.project.cab.repository.CabRepository;

@Service
public class CabService {
	
	@Autowired
	CabRepository repository;
	public String[] type = new String[] {"Sedan", "Mini", "Prime", "InterCity", "Share"};
	
	public void insertCab(Cab cab) {
		repository.save(cab);
	}
	
	public void updateCab(Cab cab) {
		repository.save(cab);
	}
	
	public void deleteCab(int cabId) {
		repository.deleteById(cabId);
	}
	
	public List<Integer> numberOfCarType() {
		List<Integer> count = new ArrayList<>();
		for(String carType:type) {
			count.add(viewCabsOfType(carType).size());
		}
		return count;
	}
	
	public List<Cab> viewCabsOfType(String carType){
		List<Cab> cabList = repository.findAll();
		if(carType.equals("All")) {
			return cabList;
		}
		cabList = cabList.stream().filter(cab -> cab.getCarType().equals(carType)).collect(Collectors.toList());
		return cabList;
	}
	public int countCabsOfType(String carType){
		List<Cab> cabList = repository.findAll();
		int count = (int)cabList.stream().filter(cab -> cab.getCarType().equals(carType)).count();
		return count;
	}
	
}
