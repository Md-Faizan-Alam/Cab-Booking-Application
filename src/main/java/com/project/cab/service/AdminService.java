package com.project.cab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.Admin;
import com.project.cab.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository repository;
	
	public void insertAdmin(Admin admin) {
		repository.save(admin);
	}
	
	public void updateAdmin(Admin admin) {
		repository.save(admin);
	}
	
	public void deleteAdmin(int adminId) {
		repository.deleteById(adminId);
	}
	
}
