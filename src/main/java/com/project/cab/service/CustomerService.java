package com.project.cab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;
}
