package com.project.cab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	
	private static int currentUser = 0;
	
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
}
