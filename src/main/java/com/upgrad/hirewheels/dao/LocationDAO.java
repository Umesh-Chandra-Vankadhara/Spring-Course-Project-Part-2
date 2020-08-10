package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entites.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("locationDAO")
public interface LocationDAO extends JpaRepository<Location,Integer> {

    Location findByAddress(String name);
}
