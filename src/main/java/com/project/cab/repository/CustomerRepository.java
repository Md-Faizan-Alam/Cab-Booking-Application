package com.project.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cab.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
