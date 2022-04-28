package com.project.cab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.cab.model.Cab;
import com.project.cab.model.Driver;
import com.project.cab.service.CabService;
import com.project.cab.service.DriverService;

@RestController
public class ApplicationController {
	@Autowired
	CabService cabService;
	@Autowired
	DriverService driverService;
	private static int currentUser = 0;
	
	@GetMapping("/")
	public ModelAndView homePage() {
		
		Cab cab1 = new Cab("Sedan", 250);
		Cab cab2 = new Cab("Prime", 230);
		Cab cab3 = new Cab("Share", 150);
		Cab cab4 = new Cab("Mini", 200);
		Cab cab5 = new Cab("InterCity", 500);
		
		cabService.insertCab(cab1);
		cabService.insertCab(cab2);
		cabService.insertCab(cab3);
		cabService.insertCab(cab4);
		cabService.insertCab(cab5);
		
		Driver driver1 = new Driver("Mohan","mohan12","redstreet","9000002201","mohan@123gmail.com","mohan_123",4.3f,cab1);
		Driver driver2 = new Driver("Rohan","rohan12","bluestreet","9000002232","rohan@gmail.com","rohan_123",4.5f,cab2);
		Driver driver3 = new Driver("Sohan","sohan12","redstreet","9000002203","sohan@123gmail.com","sohan_123",4.0f,cab3);
		Driver driver4 = new Driver("Kohan","kohan12","redstreet","9000056201","kohan@123gmail.com","kohan_123",3.5f,cab4);
		Driver driver5 = new Driver("Shohan","shohan12","redstreet","9000672201","shohan@123gmail.com","shohan_123",4.5f,cab5);
		
		driverService.insertDriver(driver1);
		driverService.insertDriver(driver2);
		driverService.insertDriver(driver3);
		driverService.insertDriver(driver4);
		driverService.insertDriver(driver5);
//		List<Driver> driverList = driverService.viewBestDrivers();
//		Driver driver = driverService.viewDriver(1);
//		for(Driver driver1:driverList) {
//			System.out.println(driver1.getLicenceNo()+" : "+driver1.getRating());			
//		}
//		System.out.println();
//		System.out.println(driver.getLicenceNo()+" : "+driver.getRating());
		return new ModelAndView("home");
	}
	@GetMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}
	@GetMapping("/register")
	public ModelAndView registerPage() {
		return new ModelAndView("register");
	}
	
}
