package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.CustomResponse;
import com.upgrad.hirewheels.dto.UserDTO;
import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.entites.User;
import com.upgrad.hirewheels.entites.Vehicle;
import com.upgrad.hirewheels.exceptions.GlobalExceptionHandler;
import com.upgrad.hirewheels.exceptions.RoleNotFoundException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.service.VehicleService;
import com.upgrad.hirewheels.util.DTOEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AdminController {
    @Autowired
    VehicleService vehicleService;

     DTOEntityMapper dtoEntityMapper;


    @PostMapping("/vehicels")
    @ResponseBody
    public ResponseEntity userSignUp(@RequestBody VehicleDTO vehicleDTO) throws GlobalExceptionHandler, RoleNotFoundException, UserAlreadyExistsException {
        ResponseEntity responseEntity = null;

        Vehicle newVehicle = dtoEntityMapper.convertVehicleDTOVehicle(vehicleDTO);
        Vehicle functionReturn = vehicleService.registerVehicle(newVehicle);
        if (functionReturn != null) {
            CustomResponse response = new CustomResponse(new Date(), "Vehicle Successfully added", 200);
            responseEntity = new ResponseEntity(response, HttpStatus.OK);
        }

        return responseEntity;
}
}
