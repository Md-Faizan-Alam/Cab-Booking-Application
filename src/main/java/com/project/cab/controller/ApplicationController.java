package com.project.cab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApplicationController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/")
	public String getMsg() {
		return "Hello from spring boot";
	}
	
}
