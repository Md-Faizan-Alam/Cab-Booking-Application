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
	
	public boolean validateMobileNo(String number) {
		if(containsAlpha(number)) {
			return false;
		}
		if(number.length()!=10) {
			return false;
		}
		if(containsOtherChar(number)) {
			return false;
		}
		
		return true;
	}
	
	public String validatePassword(String password) {
		if(password.length()<4) {
			return "Password should have atleast 4 characters";
		}
		if((!containsAlpha(password)) || (!containsNumber(password))) {
			return "Password must contain alphabets and numbers";
		}
		if(password.contains(" ")) {
			return "Password cannot contain whitespaces";
		}
		return null;
	}
	
	public boolean containsAlpha(String str) {
		for(char c='a';c<='z';c++) {
			if(str.contains(Character.toString(c))) {
				return true;
			}
		}
		for(char c='A';c<='Z';c++) {
			if(str.contains(Character.toString(c))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsNumber(String str) {
		for(char c='0';c<='9';c++) {
			if(str.contains(Character.toString(c))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsOtherChar(String str) {
		char c;
		for(int i=0;i<str.length();i++) {
			c = str.charAt(i);
			boolean check1 = (c>='a' && c<='z');
			boolean check2 = (c>='A' && c<='Z');
			boolean check3 = (c>='0' && c<='9');
			if(!check1 && !check2 && !check3) {
				return true;
			}
		}
		return false;
	}
	
}
