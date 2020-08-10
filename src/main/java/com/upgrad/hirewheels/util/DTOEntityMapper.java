package com.upgrad.hirewheels.util;


import com.upgrad.hirewheels.dto.UserDTO;
import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.entites.User;
import com.upgrad.hirewheels.entites.Vehicle;
import com.upgrad.hirewheels.exceptions.RoleNotFoundException;
import com.upgrad.hirewheels.service.RoleService;
import com.upgrad.hirewheels.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOEntityMapper {
    @Autowired
    RoleService roleService;

    @Autowired
    VehicleService vehicleService;

    public User convertUserDTOUser(UserDTO userDTO) throws RoleNotFoundException {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setWalletMoney(userDTO.getWalletMoney());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(roleService.findUserRoleDetails(userDTO.getRoleId()));
        return user;
    }

    public Vehicle convertVehicleDTOVehicle(VehicleDTO vehicleDTO)  {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleModel(vehicleDTO.getVehicleModel());
        vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
        vehicle.setColour(vehicleDTO.getColour());
        vehicle.setVehicleSubcategory(vehicleService.findVehicleSubcategoryId(vehicleDTO.getVehicleSubcategoryId()));
        vehicle.setLocation(vehicleService.findLocationDetails(vehicleDTO.getLocationId()));
        vehicle.setFuelType(vehicleService.findFuelTypeDetails(vehicleDTO.getFuelTypeId()));
        return vehicle;
    }
}
