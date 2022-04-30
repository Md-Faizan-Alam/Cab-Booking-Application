package com.project.cab.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
@DiscriminatorValue("C")
public class Customer extends User{
	
	public Customer() {}

	public Customer(String username, String password, String address, String mobileNumber, String email) {
		super(username, password, address, mobileNumber, email);
		
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + this.getUserId() + "]";
	}

	
	

}
