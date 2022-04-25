package com.project.cab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository repository;
}
