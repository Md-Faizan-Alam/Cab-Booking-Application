package com.project.cab.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Customer;
import com.project.cab.model.Driver;
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
		List<Customer> allCustomers = (List<Customer>) repository.findAll();
		return allCustomers;
	}
	
	public Customer viewCustomer(int customerId){
		Optional<Customer> customerOptional = (Optional<Customer>) repository.findById(customerId);
		Customer customer = null;
		if(customerOptional.isPresent()) {
			 customer = customerOptional.get();
		}
		return customer;
	}
	
	public boolean validateCustomer(String username, String password) {
		List<Customer> customersList = repository.findAll();
		for(Customer customer:customersList) {
			if(customer.getEmail().equalsIgnoreCase(username) || customer.getUsername().equalsIgnoreCase(username)) {
				if(customer.getPassword().equals(password)) {
					return true;
				}
			}
			
		}
		return false;
		
	}
	
}
