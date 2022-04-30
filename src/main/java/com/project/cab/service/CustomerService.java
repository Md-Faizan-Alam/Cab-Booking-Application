package com.project.cab.service;

import java.util.List;

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
		List<Customer> allCustomers = (List<Customer>) repository.findAll();
		return allCustomers;
	}
	
	public Customer viewCustomer(int customerId){
		List<Customer> customerList = repository.findAll();
		for(Customer customer:customerList) {
			if(customer.getUserId()==customerId) {
				return customer;
			}
		}
		return null;
	}
	public Customer viewCustomer(String userName){
		List<Customer> customerList = repository.findAll();
		for(Customer customer:customerList) {
			if(customer.getUsername().equals(userName) || customer.getEmail().equals(userName)) {
				return customer;
			}
		}
		return null;
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
