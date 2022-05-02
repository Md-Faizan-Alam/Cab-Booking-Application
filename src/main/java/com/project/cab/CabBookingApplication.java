package com.project.cab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.cab.controller.ApplicationController;

// The Collection rateMap used in ApplicationController is manually populated inside the
// main method of this class so that it is filled every time the program is run
// A small table for this purpose can be create in the database and filled using the DatabaseController (TO BE IMPLEMENTED)

@SpringBootApplication
public class CabBookingApplication {

	public static void main(String[] args) {
		if(ApplicationController.rateMap.isEmpty()) {
			ApplicationController.rateMap.put("Sedan",250f);
			ApplicationController.rateMap.put("Prime",230f);
			ApplicationController.rateMap.put("Share",150f);
			ApplicationController.rateMap.put("Mini",200f);
			ApplicationController.rateMap.put("InterCity",500f);
		}
		SpringApplication.run(CabBookingApplication.class, args);
	}
}
