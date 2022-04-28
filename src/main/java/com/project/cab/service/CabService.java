package com.project.cab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Cab;
import com.project.cab.model.Customer;
import com.project.cab.repository.CabRepository;

@Service
public class CabService {
	
	@Autowired
	CabRepository repository;
	
	public void insertCab(Cab cab) {
		repository.save(cab);
	}
	
	public void updateCab(Cab cab) {
		repository.save(cab);
	}
	
	public void deleteCab(int cabId) {
		repository.deleteById(cabId);
	}
	
}
