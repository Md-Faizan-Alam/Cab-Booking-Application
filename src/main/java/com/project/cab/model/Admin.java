package com.project.cab.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
@DiscriminatorValue("A")
public class Admin extends User{
		
	public Admin() {}

	public Admin(String username, String password, String address, String mobileNumber, String email) {
		super(username, password, address, mobileNumber, email);
		
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + this.getUserId() + "]";
	}
	

}
