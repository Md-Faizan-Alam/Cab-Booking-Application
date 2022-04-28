package com.project.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cab.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

}
