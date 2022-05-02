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
import com.project.cab.model.User;
import com.project.cab.service.AdminService;
import com.project.cab.service.CabService;
import com.project.cab.service.CustomerService;
import com.project.cab.service.DriverService;
import com.project.cab.service.LocationService;
import com.project.cab.service.TripBookingService;
import com.project.cab.service.UserService;


@RestController
public class ApplicationController {
	
	// Autowiring objects of various service classes that are required by the controller
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
	@Autowired
	UserService userService;
	
	// Map to get the perKmRate from the corresponding carType
	public static Map<String,Float> rateMap = new HashMap<>();
	
	// userId of the user that is currently logged in
	// userId=0 implies logged out state
	private int userId = 0;
	
	// Self-Explanatory mapping methods
	
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
	
	// Methods to reload register pages with an error message
	public ModelAndView registerCustomerPage(String message) {
		ModelAndView mav = new ModelAndView("registerCustomer");
		mav.addObject("message", message);
		return mav;
	}
	public ModelAndView registerDriverPage(String message) {
		ModelAndView mav = new ModelAndView("registerDriver");
		mav.addObject("message", message);
		return mav;
	}
	
	// Methods for validating and saving the new Customers and Drivers
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
			return registerCustomerPage("Passwords don't match");
		}
		String message = userService.validatePassword(password1);
		if(message!=null) {
			return registerCustomerPage(message);
		}
		if(!userService.validateMobileNo(mobileNumber)) {
			return registerCustomerPage("Invalid mobile number");
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
		if(!password1.equals(password2)) {
			return registerDriverPage("Passwords don't match");
		}
		String message = userService.validatePassword(password1);
		if(message!=null) {
			return registerDriverPage(message);
		}
		if(!userService.validateMobileNo(mobileNumber)) {
			return registerDriverPage("Invalid mobile number");
		}
		String carType = (String)request.getParameter("carType");
		Cab cab = new Cab(carType, rateMap.get(carType));
		Driver driver = new Driver(userName,password1,address,mobileNumber,email,licenceNo,0.0f,cab);
		driverService.insertDriver(driver);
		return mav;
	}
	
	// Method to show a list of available cabs to the customer
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
	
	// A custom homepage for admins allowing them to manage various modules
	@PostMapping("/adminLog")
	public ModelAndView adminLog() {
		ModelAndView mav = new ModelAndView("adminLog");
		return mav;
	}
	
	// A custom homepage for drivers showing them their details
	@GetMapping("/driverLog")
	public ModelAndView driverLog() {
		ModelAndView mav = new ModelAndView("driverLog");
		mav.addObject("driver",driverService.viewDriver(userId));
		return mav;
	}
	
	
	@GetMapping("/book")
	public ModelAndView bookingPage() {
		ModelAndView mav = new ModelAndView("book");
		if(userService.viewUser(userId) instanceof Admin) {
			return adminLog();
		}
		if(userService.viewUser(userId) instanceof Driver) {
			return driverLog();
		}
		mav.addObject("userName",customerService.viewCustomer(userId).getUsername());
		List<Location> locationList = locationService.getAllLocations();
		mav.addObject("locationList", locationList);
		return mav;
	}
	@GetMapping("/loggedHome")
	public ModelAndView loggedHome() {
		ModelAndView mav = new ModelAndView("loggedHome");
		User user = customerService.viewCustomer(userId);
		if(user==null) {
			user = adminService.viewAdmin(userId);
		}
		if(user==null) {
			user = driverService.viewDriver(userId);
		}
		String userName = user.getUsername();
		mav.addObject("userName",userName);
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
	
	// Method to be called when user clicks on the "Wheelin" logo
	// It will check for the user's type (Admin,Customer,Driver)
	// and send them to their respective homepages (adminLog,homePage,driverLog)
	@GetMapping("/headHome")
	public ModelAndView headHome() {
		if(userId==0) {
			return homePage();
		}
		User user = userService.viewUser(userId);
		if(user instanceof Customer) {
			return loggedHome();
		}
		if(user instanceof Admin) {
			return adminLog();
		}
		return driverLog();
	}
	
	// Method to be called by the Login button on the login page
	// Validates the credentials and sends the user to their respective homepages
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
	
	// Admin's Management Pages (Should be accessible only to Admins)
	
	// Displays the no. of cabs for each carType
	@GetMapping("/cabManagement")
	public ModelAndView cabManagement() {
		ModelAndView mav =new ModelAndView("cabManagement");
		mav.addObject("userName",adminService.viewAdmin(userId).getUsername());
		mav.addObject("count",cabService.numberOfCarType());
		return mav;
	}
	
	// Displays the Best Drivers
	@GetMapping("/driverManagement")
	public ModelAndView driverManagement() {
		ModelAndView mav =new ModelAndView("driverManagement");
		mav.addObject("userName",adminService.viewAdmin(userId).getUsername());
		mav.addObject("bestDrivers",driverService.viewBestDrivers());
		return mav;
	}
	
	// Allows the admin to search for Trip Bookings by carType, Customer and Driver
	@GetMapping("/bookingManagement")
	public ModelAndView bookingManagement() {
		ModelAndView mav =new ModelAndView("bookingManagement");
		mav.addObject("userName",adminService.viewAdmin(userId).getUsername());
		return mav;
	}
	
	// Method to be called by the Search button in the bookingManagement page
	// Displays the tripLog page which contains the list of all TripBookings
	// That match the Search keyword
	// Displays a block	with the message "No Results" if no TripBookings are found
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

//	To be solved -	Pages that are supposed to be accessible only after logging in can be manually
//					accessed by typing in the url in the browser, and this forced access gives an error
//	For Example	-	Cab Managements should only be accessible by the Admin after logging in
//					But as of right now it can be accessed by putting the url
//					http://localhost:8085/cabManagement manually in the browser
//					The attempt to forcefully access these pages will result in an error