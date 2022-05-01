package com.project.cab.controller;

import java.util.ArrayList;
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
	
	public static Map<String,Float> rateMap = new HashMap<>();
	
	private int userId = 0 ;
	
	@GetMapping("/")
	public ModelAndView homePage() {
		if(userId==0) {
			return new ModelAndView("home");
		}
		return loggedHome();
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
		mav.addObject("userName",customerService.viewCustomer(userId).getUsername());
		return mav;
	}
	
	@PostMapping("/adminLog")
	public ModelAndView adminLog(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("adminLog");
		return mav;
	}
	
	@GetMapping("/driverLog")
	public ModelAndView driverLog() {
		ModelAndView mav = new ModelAndView("driverLog");
		mav.addObject("driver",driverService.viewDriver(userId));
		//rating method was never called but still rating was shown in front-end
		//FZN: As far as I can see it was called at line no. 69
		//not getting the username  after welcome - FIXED
		return mav;
	}
	
	@GetMapping("/book")
	public ModelAndView bookingPage() {
		ModelAndView mav = new ModelAndView("book");
		mav.addObject("userName",customerService.viewCustomer(userId).getUsername());
		List<Location> locationList = locationService.getAllLocations();
		mav.addObject("locationList", locationList);
		return mav;
	}
	@GetMapping("/loggedHome")
	public ModelAndView loggedHome() {
		ModelAndView mav = new ModelAndView("loggedHome");
		mav.addObject("userName",customerService.viewCustomer(userId).getUsername());
		return mav;
	}
	
	@PostMapping("/rate")
	public ModelAndView rateDriver(HttpServletRequest request) {
		int driverId = Integer.parseInt(request.getParameter("driverId"));
		String str = request.getParameter("rating");
		int rating = 0;
		if(str==null) {
			rating = 2;
		}
		else {
			rating = Integer.parseInt(str);
		}
		driverService.updateRating(driverId,rating);
		return bookingPage();
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
		mav.addObject("userName",customerService.viewCustomer(userId).getUsername());
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		userId = 0;
		return homePage();
	}
	
	@GetMapping("/headHome")
	public ModelAndView headHome() {
		if(userId==0) {
			return homePage();
		}
		return loggedHome();
	}
	
	
	@PostMapping("/sign")
	public ModelAndView signIn(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("message","Incorrect username or password");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		if(adminService.validateAdmin(userName, password, type)) {
			Admin admin = adminService.viewAdmin(userName);
			userId = admin.getUserId();
			mav.setViewName("adminLog");
			mav.addObject("admin", admin);
		}
		else if(customerService.validateCustomer(userName, password, type)) {
			Customer customer = customerService.viewCustomer(userName);
			userId = customer.getUserId();
			return bookingPage();
		}
		else if(driverService.validateDriver(userName, password, type)) {
			Driver driver = driverService.viewDriver(userName);
			userId = driver.getUserId();
			return driverLog();
		}
		return mav;
	}
	
	@GetMapping("/cabManagement")
	public ModelAndView cabManagement() {
		ModelAndView mav =new ModelAndView("cabManagement");
		mav.addObject("userName",adminService.viewAdmin(userId).getUsername());
		mav.addObject("count",cabService.numberOfCarType());
		return mav;
	}
	
	@GetMapping("/driverManagement")
	public ModelAndView driverManagement() {
		ModelAndView mav =new ModelAndView("driverManagement");
		mav.addObject("userName",adminService.viewAdmin(userId).getUsername());
		mav.addObject("bestDrivers",driverService.viewBestDrivers());
		return mav;
	}
	
	@GetMapping("/bookingManagement")
	public ModelAndView bookingManagement() {
		ModelAndView mav =new ModelAndView("bookingManagement");
		mav.addObject("userName",adminService.viewAdmin(userId).getUsername());
		return mav;
	}
	
	@PostMapping("/search")
	public ModelAndView search(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("tripLog");
		List<TripBooking> tripList = new ArrayList<>();
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		if(type.equals("CA")) {
			tripList = adminService.getTripsCabwise(keyword);
		}
		else if(type.equals("CU")) {
			tripList = adminService.getTripsCustomerwise(keyword);
		}
		else if(type.equals("DR")) {
			tripList = adminService.getTripsDriverwise(keyword);
		}
		mav.addObject("display",(tripList.isEmpty() ? "block" : "none"));
		mav.addObject("tripList",tripList);
		mav.addObject("userName",adminService.viewAdmin(userId).getUsername());
		return mav;
		
	}
}
