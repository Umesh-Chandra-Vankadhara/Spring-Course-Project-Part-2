package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entites.FuelType;
import com.upgrad.hirewheels.entites.Location;
import com.upgrad.hirewheels.entites.Vehicle;
import com.upgrad.hirewheels.entites.VehicleSubcategory;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();

    Vehicle registerVehicle(Vehicle vehicle);

    FuelType findFuelTypeDetails(int fuelTypeId);

    Location findLocationDetails(int locationId);

    VehicleSubcategory findVehicleSubcategoryId(int vehicleSubcategoryId);
}
