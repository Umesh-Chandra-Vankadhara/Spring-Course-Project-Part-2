package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entites.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDAO  extends JpaRepository<Vehicle,Integer> {
}
