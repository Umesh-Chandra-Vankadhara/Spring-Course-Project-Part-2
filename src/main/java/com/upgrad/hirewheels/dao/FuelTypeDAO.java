package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entites.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("fuelTypeDAO")
public interface FuelTypeDAO extends JpaRepository<FuelType,Integer> {

    FuelType findByFuelTypeId(int i);
}
