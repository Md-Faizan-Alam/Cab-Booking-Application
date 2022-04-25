package com.project.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cab.model.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer>{

}
