package com.project.cab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository repository;
	
}
