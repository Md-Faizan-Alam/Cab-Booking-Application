package com.project.cab.service;

import java.time.LocalDateTime;
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
	public boolean validateAdmin(String userName,String password) {
		List<Admin> adminList = adminRepository.findAll();
		for(Admin admin:adminList) {
			if(admin.getEmail().equalsIgnoreCase(userName) || admin.getUsername().equalsIgnoreCase(userName)) {
				if(admin.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Admin viewAdmin(String userName) {
		List<Admin> adminList = adminRepository.findAll();
		for(Admin admin:adminList) {
			if(admin.getUsername().equals(userName)) {
				return admin;
			}
		}
		return null;
	}
	
	public List<TripBooking> getTripsCustomerwise(int customerId) {
		List<Customer> customerList = customerRepository.findAll();
		for(Customer customer:customerList) {
			if(customer.getUserId()==customerId) {
				List<TripBooking> tripList=tripRepository.findAll();
				tripList = tripList.stream().filter(trip -> trip.getCustomer().getUserId()==customerId).collect(Collectors.toList());
				return tripList;
			}
		}
		return null;
		
	}
	
	public List<TripBooking> getAllTripsForDays(LocalDateTime fromDate, LocalDateTime toDate) {
		List<TripBooking> tripList=tripRepository.findAll();
		tripList = tripList.stream().filter(trip -> trip.getFromDateTime().isAfter(fromDate) && trip.getToDateTime().isBefore(toDate)).collect(Collectors.toList());
		return tripList;
	}
	
	
	public List<TripBooking> getTripsDriverwise(int driverId) {
		List<Driver> driverList = driverRepository.findAll();
		for(Driver driver:driverList) {
			if(driver.getUserId()==driverId) {
				List<TripBooking> tripList=tripRepository.findAll();
				tripList = tripList.stream().filter(trip -> trip.getDriver().getUserId()==driverId).collect(Collectors.toList());
				return tripList;
			}
		}
		return null;
		
	}
	
	public List<TripBooking> getTripsCabwise(String carType) {
		List<Cab> cabList = cabRepository.findAll();
		for(Cab cab:cabList) {
			if(cab.getCarType()==carType) {
				List<TripBooking> tripList=tripRepository.findAll();
				tripList = tripList.stream().filter(trip -> trip.getDriver().getCab().getCarType()==carType).collect(Collectors.toList());
				return tripList;
			}
		}
		return null;
		
	}
}
