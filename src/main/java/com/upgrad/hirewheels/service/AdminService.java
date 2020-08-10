package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entites.Vehicle;

public interface AdminService {
    Vehicle registerVehicle(Vehicle vehicle);
    Vehicle updateVehicle(int id,Vehicle vehicle);
    Vehicle changeAvailability(int id,Vehicle vehicle);
}
