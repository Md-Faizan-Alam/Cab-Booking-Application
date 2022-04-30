package com.project.cab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.cab.controller.ApplicationController;

// This is the first change that made
// FZN: Rebase Test 1
// JK: Rebase Test 3
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
