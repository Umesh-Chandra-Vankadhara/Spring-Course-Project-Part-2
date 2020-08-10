package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entites.City;
import com.upgrad.hirewheels.entites.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCategoryDAO  extends JpaRepository<VehicleCategory,Integer> {
    VehicleCategory findByVehicleCategoryName(String name);
}
