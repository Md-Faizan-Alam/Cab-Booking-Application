package com.project.cab.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

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
import com.project.cab.repository.LocationRepository;
import com.project.cab.repository.UserRepository;
import com.project.cab.service.AdminService;
import com.project.cab.service.CabService;
import com.project.cab.service.CustomerService;
import com.project.cab.service.DriverService;

@RestController
public class ApplicationController {
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	CabService cabService;
	@Autowired
	CustomerService customerService;
	@Autowired
	DriverService driverService;
	@Autowired
	AdminService adminService;
	@Autowired
	UserRepository userRepository;
	
	private static int customerId = 0 ;
	
	@GetMapping("/")
	public ModelAndView homePage() {
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
		System.out.println("I was her 1");
		ModelAndView mav = new ModelAndView("home");
		System.out.println("I was her 2");
		String userName = (String)request.getParameter("userName");
		String address = (String)request.getParameter("address");
		String mobileNumber = (String)request.getParameter("mobileNumber");
		String email = (String)request.getParameter("email");
		String licenceNo = (String)request.getParameter("licenceNo");
		String password1 = (String)request.getParameter("password1");
		String password2 = (String)request.getParameter("password2");
		System.out.println("I was her 3");
		if(!password1.equals(password2)) {
			System.out.println("I was her 4");
			mav.setViewName("registerDriver");
			return mav;
		}
		System.out.println("I was her 5");
		String carType = (String)request.getParameter("carType");
		Cab cab = new Cab(carType, Cab.rateMap.get(carType));
		Driver driver = new Driver(userName,password1,address,mobileNumber,email,licenceNo,0.0f,cab);
		driverService.insertDriver(driver);
		System.out.println("I was her 6");
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
	
	
	@GetMapping("/book")
	public ModelAndView bookingPage() {
		ModelAndView mav = new ModelAndView("book");
		String userName = customerService.viewCustomer(customerId).getUsername();
		mav.addObject("userName",userName);
		List<Location> locationList = locationRepository.findAll();
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
		mav.addObject("driver", driver);
		mav.addObject("toLocation", toLocation);
		mav.addObject("fromLocation", fromLocation);
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
				customerId = customer.getCustomerId();
				mav.addObject("userName", customer.getUsername());
				List<Location> locationList = locationRepository.findAll();
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
