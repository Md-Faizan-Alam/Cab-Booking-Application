package com.project.cab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cab.model.User;
import com.project.cab.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	
	public User viewUser(int userId) {
		List<User> userList = repository.findAll();
		for(User user:userList) {
			if(user.getUserId()==userId) {
				return user;
			}
		}
		return null;
	}
}
