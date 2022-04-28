package com.project.cab.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Admin;
import com.project.cab.model.TripBooking;
import com.project.cab.repository.AdminRepository;
import com.project.cab.repository.TripBookingRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	TripBookingRepository tripRepository;
	
	public void insertAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	public void updateAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	public void deleteAdmin(int adminId) {
		adminRepository.deleteById(adminId);
	}
	
	public List<TripBooking> getAllTrips(int customerId){
		List<TripBooking> tripList = tripRepository.findAll();
		tripList = tripList.stream().filter(trip -> trip.getCustomer().getCustomerId()==customerId).collect(Collectors.toList());
		return tripList;
	}
	
}
