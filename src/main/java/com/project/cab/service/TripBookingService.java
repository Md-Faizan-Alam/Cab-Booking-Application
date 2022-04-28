package com.project.cab.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.cab.model.TripBooking;
import com.project.cab.repository.TripBookingRepository;

public class TripBookingService {
	@Autowired
	TripBookingRepository repository;
	
	public void insertTripBooking(TripBooking tripBooking) {
		repository.save(tripBooking);
	}
	
	public void updateTripBooking(TripBooking tripBooking) {
		repository.save(tripBooking);
	}
	
	public void deleteTripBooking(int tripBookingId) {
		repository.deleteById(tripBookingId);
	}
	
	public List<TripBooking> viewAllTripsCustomer(int customerId){
		List<TripBooking> tripList = repository.findAll();
		tripList = tripList.stream().filter(trip -> trip.getCustomerId()==customerId).collect(Collectors.toList());
		return tripList;
	}
	
	public float calculateBill(int customerId) {
		List<TripBooking> tripList = repository.findAll();
		tripList = tripList.stream().filter(trip -> trip.getCustomerId()==customerId).collect(Collectors.toList());
		float totalBill = 0;
		for(TripBooking trip:tripList) {
			totalBill += trip.getBill();
		}
		return totalBill;
	}
	
	
}
