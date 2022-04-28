package com.project.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cab.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
