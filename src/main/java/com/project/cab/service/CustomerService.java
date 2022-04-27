package com.project.cab.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Customer;
import com.project.cab.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;
	
	public void insertCustomer(Customer customer) {
		repository.save(customer);
	}
	
	public void updateCustomer(Customer customer) {
		repository.save(customer);
	}
	
	public void deleteCustomer(int customerId) {
		repository.deleteById(customerId);
	}
	
	public List<Customer> viewCustomers(){
		List<Customer> allCustomers = repository.findAll();
		allCustomers = allCustomers.stream().collect(Collectors.toList());
		return allCustomers;
	}
	
	public List<Customer> viewCustomer(int customerId){
		List<Customer> customersId = repository.findAll();
		customersId = customersId.stream().filter(customers -> customers.getCustomerId()==customerId).collect(Collectors.toList());
		return customersId;
	}
	
	public Customer validateCustomer(String username, String password) {
		List<Customer> customersList = repository.findAll();
		for(Customer customer:customersList) {
//			if(customer.getEmail().equalsIgnoreCase(username))
			if(customer.getUsername().equalsIgnoreCase(username)) {
				if(customer.getPassword().equals(password)) {
					return customer;
				}
			}
		}
		return null;
		
	}
	
}
