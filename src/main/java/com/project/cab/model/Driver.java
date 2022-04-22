package com.project.cab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DRIVER")
public class Driver extends AbstractUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	
	@Column(name = "licence_number")
	private String licenceNo;
	
	@Column(name = "rating_of_driver")
	private float rating;
	
	public Driver() {}

	public Driver(int driverId, String licenceNo, float rating) {
		super();
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.rating = rating;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	

}
