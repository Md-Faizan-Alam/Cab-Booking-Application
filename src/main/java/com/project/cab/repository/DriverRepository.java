package com.project.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cab.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

}
