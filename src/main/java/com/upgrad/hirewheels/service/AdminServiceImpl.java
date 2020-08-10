package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.VehicleDAO;
import com.upgrad.hirewheels.entites.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    VehicleDAO vehicleDAO;

    @Override
    public Vehicle registerVehicle(Vehicle vehicle) {
        return vehicleDAO.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(int id, Vehicle vehicle) {
        return vehicleDAO.save(vehicle);
    }

    @Override
    public Vehicle changeAvailability(int id, Vehicle vehicle) {
        return vehicleDAO.save(vehicle);
    }
}
