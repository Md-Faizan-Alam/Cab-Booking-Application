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
	@GetMapping("/register")
	public ModelAndView registerPage() {
		return new ModelAndView("register");
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
