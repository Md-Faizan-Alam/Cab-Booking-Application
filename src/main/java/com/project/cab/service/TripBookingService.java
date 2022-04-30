package com.project.cab.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Customer;
import com.project.cab.model.Driver;
import com.project.cab.model.TripBooking;
import com.project.cab.repository.TripBookingRepository;

@Service
public class TripBookingService {
	@Autowired
	TripBookingRepository repository;
	@Autowired
	LocationService locationService;
	
	public TripBooking createTripBooking(Customer customer, Driver driver, String fromLocation, String toLocation) {
		
		TripBooking trip = new TripBooking(customer,driver,fromLocation,toLocation);
		
		LocalDateTime fromTime = LocalDateTime.now();
		float distance = locationService.getDistance(fromLocation, toLocation);
		float bill = driver.getCab().getPerKmRate()*distance;
		LocalDateTime toTime = fromTime.plusMinutes((long)distance*2);
		
		trip.setFromDateTime(fromTime);
		trip.setToDateTime(toTime);
		trip.setDistanceInKm(distance);
		trip.setBill(bill);
		
		return trip;
	}
	
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
		tripList = tripList.stream().filter(trip -> trip.getCustomer().getUserId()==customerId).collect(Collectors.toList());
		return tripList;
	}
	
	public float calculateBill(int customerId) {
		List<TripBooking> tripList = repository.findAll();
		tripList = tripList.stream().filter(trip -> trip.getCustomer().getUserId()==customerId).collect(Collectors.toList());
		float totalBill = 0;
		for(TripBooking trip:tripList) {
			totalBill += trip.getBill();
		}
		return totalBill;
	}
	public int getNoOfTrips(int driverId) {
		List<TripBooking> tripList = repository.findAll();
		return (int)tripList.stream().filter(trip -> trip.getDriver().getUserId()==driverId).count();
	}
	
}
