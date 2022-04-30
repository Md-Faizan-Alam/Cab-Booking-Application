package com.project.cab.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="DRIVER")
@DiscriminatorValue("D")
public class Driver extends User{
	
	@Column(name = "licence_number")
	private String licenceNo;
	
	@OneToOne(targetEntity = Cab.class)
	@Cascade(CascadeType.ALL)
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
