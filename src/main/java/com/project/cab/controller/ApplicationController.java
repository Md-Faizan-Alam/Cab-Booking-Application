package com.project.cab.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.cab.model.Admin;
import com.project.cab.model.Cab;
import com.project.cab.model.Customer;
import com.project.cab.model.Driver;
import com.project.cab.model.Location;
import com.project.cab.model.TripBooking;
import com.project.cab.service.AdminService;
import com.project.cab.service.CabService;
import com.project.cab.service.CustomerService;
import com.project.cab.service.DriverService;
import com.project.cab.service.LocationService;
import com.project.cab.service.TripBookingService;

@RestController
public class ApplicationController {
	@Autowired
	LocationService locationService;
	@Autowired
	CabService cabService;
	@Autowired
	CustomerService customerService;
	@Autowired
	DriverService driverService;
	@Autowired
	AdminService adminService;
	@Autowired
	TripBookingService tripService;
	
	public Map<String,Float> rateMap = new HashMap<>();
	
	private int userId = 0 ;
	
	@GetMapping("/")
	public ModelAndView homePage() {
		if(rateMap.isEmpty()) {
			rateMap.put("Sedan",250f);
			rateMap.put("Prime",230f);
			rateMap.put("Share",150f);
			rateMap.put("Mini",200f);
			rateMap.put("InterCity",500f);
		}
		return new ModelAndView("home");
	}
	@GetMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}
	@GetMapping("/registerCustomer")
	public ModelAndView registerCustomerPage() {
		return new ModelAndView("registerCustomer");
	}
	@GetMapping("/registerDriver")
	public ModelAndView registerDriverPage() {
		return new ModelAndView("registerDriver");
	}
	
	@PostMapping("/saveCustomer")
	public ModelAndView saveCustomer(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home");
		String userName = (String)request.getParameter("userName");
		String address = (String)request.getParameter("address");
		String mobileNumber = (String)request.getParameter("mobileNumber");
		String email = (String)request.getParameter("email");
		String password1 = (String)request.getParameter("password1");
		String password2 = (String)request.getParameter("password2");
		if(!password1.equals(password2)) {
			mav.setViewName("registerCustomer");
			return mav;
		}
		Customer customer = new Customer(userName,password1,address,mobileNumber,email);
		customerService.insertCustomer(customer);
		return mav;
		
	}
	
	@PostMapping("/saveDriver")
	public ModelAndView saveDriver(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home");
		String userName = (String)request.getParameter("userName");
		String address = (String)request.getParameter("address");
		String mobileNumber = (String)request.getParameter("mobileNumber");
		String email = (String)request.getParameter("email");
		String licenceNo = (String)request.getParameter("licenceNo");
		String password1 = (String)request.getParameter("password1");
		String password2 = (String)request.getParameter("password2");
		System.out.println("I was here 1");
		if(!password1.equals(password2)) {
			mav.setViewName("registerDriver");
			return mav;
		}
		System.out.println("I was here 2");
		String carType = (String)request.getParameter("carType");
		System.out.println("I was here 3");
		Cab cab = new Cab(carType, rateMap.get(carType));
		System.out.println("I was here 4");
		Driver driver = new Driver(userName,password1,address,mobileNumber,email,licenceNo,0.0f,cab);
		System.out.println("I was here 5");
		driverService.insertDriver(driver);
		System.out.println("I was here 6");
		return mav;
	}
	
	@PostMapping("/customerLog")
	public ModelAndView customerLog(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("customerLog");
		String fromLocation = (String)request.getParameter("fromLocation");
		String toLocation = (String)request.getParameter("toLocation");
		String carType = (String)request.getParameter("carType");
		List<Driver> driverList = driverService.viewDriversWithCarType(carType);
		mav.addObject("driverList",driverList);
		mav.addObject("fromLocation",fromLocation);
		mav.addObject("toLocation",toLocation);
		return mav;
	}
	
	@PostMapping("/adminLog")
	public ModelAndView adminLog(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("adminLog");
//		int customerId = (int)request.getParameter(customerId);
//		String userName = (String)request.getParameter("userName");
//		String licenceNo = (String)request.getParameter("licenceNo");
//		String carType = (String)request.getParameter("carType");
//		List<Driver> driverList = driverService.viewDriversWithCarType(carType);
//		mav.addObject("driverList",driverList);
//		mav.addObject("userName",userName);
//		mav.addObject("licenceNo",licenceNo);
		return new ModelAndView("adminLog");
//		return mav;
	}
	
	@GetMapping("/book")
	public ModelAndView bookingPage() {
		ModelAndView mav = new ModelAndView("book");
		String userName = customerService.viewCustomer(userId).getUsername();
		mav.addObject("userName",userName);
		List<Location> locationList = locationService.getAllLocations();
		mav.addObject("locationList", locationList);
		return mav;
	}
	@PostMapping("/rate")
	public ModelAndView rateDriver(HttpServletRequest request) {
		
		int driverId = Integer.parseInt(request.getParameter("driverId"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		driverService.updateRating(driverId,rating);
		
		ModelAndView mav = new ModelAndView("book");
		String userName = customerService.viewCustomer(userId).getUsername();
		mav.addObject("userName",userName);
		List<Location> locationList = locationService.getAllLocations();
		mav.addObject("locationList", locationList);
		return mav;
	}
	
	@PostMapping("/confirm")
	public ModelAndView confirmationPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("confirm");
		String fromLocation = request.getParameter("fromLocation");
		String toLocation = request.getParameter("toLocation");
		int driverId = Integer.parseInt(request.getParameter("driverId"));
		Driver driver = driverService.viewDriver(driverId);
		Customer customer = customerService.viewCustomer(userId);
		TripBooking trip = tripService.createTripBooking(customer, driver, fromLocation, toLocation);
		tripService.insertTripBooking(trip);
		mav.addObject("trip",trip);
		return mav;
	}
	@PostMapping("/sign")
	public ModelAndView signIn(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login");
		String userName = (String)request.getParameter("userName");
		String password = (String)request.getParameter("password");
		String type = (String)request.getParameter("type");
		System.out.println(userName+" "+password+" "+type);
		switch (type) {
		case "A":
			Admin admin = adminService.viewAdmin(userName);
			if(admin != null && admin.getPassword().equals(password)) {
				mav.setViewName("admin");
				mav.addObject("admin", admin);
			}
			break;
		case "C":
			Customer customer = customerService.viewCustomer(userName);
			if(customer != null && customer.getPassword().equals(password)) {
				mav.setViewName("book");
				userId = customer.getUserId();
				mav.addObject("userName", customer.getUsername());
				List<Location> locationList = locationService.getAllLocations();
				mav.addObject("locationList", locationList);
			}
			break;
		case "D":
			Driver driver = driverService.viewDriver(userName);
			if(driver!=null && driver.getPassword().equals(password)) {
				mav.setViewName("driver");
				mav.addObject("driver", driver);
			}
			break;
		}
		return mav;
	}
	
}
