package com.project.cab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cab.model.Cab;
import com.project.cab.model.Customer;
import com.project.cab.model.Driver;
import com.project.cab.model.Location;
import com.project.cab.repository.LocationRepository;
import com.project.cab.service.CabService;
import com.project.cab.service.CustomerService;
import com.project.cab.service.DriverService;

@RestController
public class DatabaseController {
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	CabService cabService;
	@Autowired
	DriverService driverService;
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/postLocation")
	public void postLocation() {
		Location local1 = new Location("Exide");
		Location local2 = new Location("NarkelBagan");
		Location local3 = new Location("Seven-Point");
		Location local4 = new Location("Rajabazar");
		Location local5 = new Location("Khidderpore");
		
		locationRepository.save(local1);
		locationRepository.save(local2);
		locationRepository.save(local3);
		locationRepository.save(local4);
		locationRepository.save(local5);
	}
	
	@GetMapping("/postDriver")
	public void postDriver() {
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
	}
	
	@GetMapping("/postCustomer")
	public void postCustomer() {
		Customer customer1 = new Customer("Anthony","anthony123","redstreet","9000002201","anthony@123gmail.com");		
		Customer customer2 = new Customer("Bruce","bruce123","redstreet","9000002201","bruce@123gmail.com");		
		Customer customer3 = new Customer("Carla","carla123","redstreet","9000002201","carla@123gmail.com");		
		Customer customer4 = new Customer("David","david123","redstreet","9000002201","david@123gmail.com");		
		Customer customer5 = new Customer("Emily","emily123","redstreet","9000002201","emily@123gmail.com");	
		
		customerService.insertCustomer(customer1);
		customerService.insertCustomer(customer2);
		customerService.insertCustomer(customer3);
		customerService.insertCustomer(customer4);
		customerService.insertCustomer(customer5);
	}
	
	@GetMapping("/test")
	public void testMethod() {
		List<Driver> driverList = driverService.viewBestDrivers();
		Driver driver = driverService.viewDriver(1);
		for(Driver driver1:driverList) {
			System.out.println(driver1.getLicenceNo()+" : "+driver1.getRating());			
		}
		System.out.println();
		System.out.println(driver.getLicenceNo()+" : "+driver.getRating());
		
	}
	
}
