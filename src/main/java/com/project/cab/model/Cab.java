package com.project.cab.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAB")
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cabId;
	
	@Column(name = "car_type")
	private String carType;
	
	private float perKmRate;
	
	public static transient Map<String, Float> rateMap = new HashMap<>();
	
	static {
		rateMap.put("Sedan", 250f);
		rateMap.put("Prime", 230f);
		rateMap.put("Share", 150f);
		rateMap.put("Mini", 200f);
		rateMap.put("InterCity", 500f);
	}
	
	public Cab() {}

	public Cab(String carType, float perKmRate) {
		super();		
		this.carType = carType;
		this.perKmRate = perKmRate;
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	
	

}
