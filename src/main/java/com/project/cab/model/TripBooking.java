package com.project.cab.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRIPS")
public class TripBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trip_booking_id")
	private int tripBookingId;
	@Column(name = "customer_id")
	private int customerId;
	@OneToOne(targetEntity = Driver.class)
	private Driver driver;
	@Column(name = "from_location")
	private String fromLocation;
	@Column(name = "to_location")
	private String toLocation;
	@Column(name = "from_time")
	private LocalDateTime fromDateTime;
	@Column(name = "to_time")
	private LocalDateTime toDateTime;
	private boolean status;
	@Column(name = "distance_in_km")
	private float distanceInKm;
	@Column(name = "fare")
	private float bill;
	
	public TripBooking(){}
	
	public TripBooking(int tripBookingId, int customerId, Driver driver, String fromLocation, String toLocation,
			LocalDateTime fromDateTime, LocalDateTime toDateTime, boolean status, float distanceInKm, float bill) {
		this.tripBookingId = tripBookingId;
		this.customerId = customerId;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}

	public int getTripBookingId() {
		return tripBookingId;
	}

	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

}
