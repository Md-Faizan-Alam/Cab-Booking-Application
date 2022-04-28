package com.project.cab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DRIVER")
public class Driver extends AbstractUser{
	//AD changing
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "driver_id")
	private int driverId;
	
	@Column(name = "licence_number")
	private String licenceNo;
	
	@OneToOne(targetEntity = Cab.class)
	private Cab cab;

	@Column(name = "rating_of_driver")
	private float rating;
	
	public Driver() {}
	
	public Driver(String username, String password, String address, String mobileNumber, String email, String licenceNo, float rating, Cab cab) {
		super(username, password, address, mobileNumber, email);
		this.licenceNo = licenceNo;
		this.cab = cab;
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
	
	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}


	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	

}
