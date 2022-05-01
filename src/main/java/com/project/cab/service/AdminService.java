package com.project.cab.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Admin;
import com.project.cab.model.Cab;
import com.project.cab.model.Customer;
import com.project.cab.model.Driver;
import com.project.cab.model.TripBooking;
import com.project.cab.repository.AdminRepository;
import com.project.cab.repository.CabRepository;
import com.project.cab.repository.CustomerRepository;
import com.project.cab.repository.DriverRepository;
import com.project.cab.repository.TripBookingRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	TripBookingRepository tripRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	DriverRepository driverRepository;
	@Autowired
	CabRepository cabRepository;
	
	public void insertAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	public void updateAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	public void deleteAdmin(int adminId) {
		adminRepository.deleteById(adminId);
	}
	
	public List<TripBooking> getAllTrips(){
		List<TripBooking> tripList = tripRepository.findAll();
		return tripList;
	}
	
	public boolean validateAdmin(String userName,String password,String type) {
		if(type.equals("A")) {
			List<Admin> adminList = adminRepository.findAll();
			for(Admin admin:adminList) {
				if((admin.getEmail().equalsIgnoreCase(userName) || admin.getUsername().equalsIgnoreCase(userName)) && admin.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	public Admin viewAdmin(int adminId){
		List<Admin> adminList = adminRepository.findAll();
		for(Admin admin:adminList) {
			if(admin.getUserId()==adminId) {
				return admin;
			}
		}
		return null;
	}
	public Admin viewAdmin(String userName) {
		List<Admin> adminList = adminRepository.findAll();
		for(Admin admin:adminList) {
			if(admin.getUsername().equalsIgnoreCase(userName)) {
				return admin;
			}
		}
		return null;
	}
	
	public List<TripBooking> getTripsCustomerwise(String userName) {
		List<Customer> customerList = customerRepository.findAll();
		for(Customer customer:customerList) {
			if(customer.getUsername().equalsIgnoreCase(userName)) {
				List<TripBooking> tripList=tripRepository.findAll();
				tripList = tripList.stream().filter(trip -> trip.getCustomer().getUsername().equalsIgnoreCase(userName)).collect(Collectors.toList());
				return tripList;
			}
		}
		return new ArrayList<>();
		
	}
	
	public List<TripBooking> getAllTripsForDays(LocalDateTime fromDate, LocalDateTime toDate) {
		List<TripBooking> tripList=tripRepository.findAll();
		tripList = tripList.stream().filter(trip -> trip.getFromDateTime().isAfter(fromDate) && trip.getToDateTime().isBefore(toDate)).collect(Collectors.toList());
		return tripList;
	}
	
	
	public List<TripBooking> getTripsDriverwise(String userName) {
		List<Driver> driverList = driverRepository.findAll();
		for(Driver driver:driverList) {
			if(driver.getUsername().equalsIgnoreCase(userName)) {
				List<TripBooking> tripList=tripRepository.findAll();
				tripList = tripList.stream().filter(trip -> trip.getDriver().getUsername().equalsIgnoreCase(userName)).collect(Collectors.toList());
				return tripList;
			}
		}
		return new ArrayList<>();
		
	}
	
	public List<TripBooking> getTripsCabwise(String carType) {
		List<Cab> cabList = cabRepository.findAll();
		for(Cab cab:cabList) {
			if(cab.getCarType().equalsIgnoreCase(carType)) {
				List<TripBooking> tripList=tripRepository.findAll();
				tripList = tripList.stream().filter(trip -> trip.getDriver().getCab().getCarType().equalsIgnoreCase(carType)).collect(Collectors.toList());
				return tripList;
			}
		}
		return new ArrayList<>();
		
	}
}
