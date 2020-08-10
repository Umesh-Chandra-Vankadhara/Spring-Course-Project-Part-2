package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.VehicleDAO;
import com.upgrad.hirewheels.entites.FuelType;
import com.upgrad.hirewheels.entites.Location;
import com.upgrad.hirewheels.entites.Vehicle;
import com.upgrad.hirewheels.entites.VehicleSubcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleDAO vehicleDAO;
    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.findAll();
    }

    @Override
    public Vehicle registerVehicle(Vehicle vehicle) {
        return vehicleDAO.save(vehicle);
    }

    @Override
    public FuelType findFuelTypeDetails(int fuelTypeId) {
        return null;
    }

    @Override
    public Location findLocationDetails(int locationId) {
        return null;
    }

    @Override
    public VehicleSubcategory findVehicleSubcategoryId(int vehicleSubcategoryId) {
        return null;
    }
}
