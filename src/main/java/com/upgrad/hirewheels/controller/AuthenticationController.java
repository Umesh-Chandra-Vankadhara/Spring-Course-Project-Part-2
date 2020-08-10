package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.CustomResponse;
import com.upgrad.hirewheels.dto.ForgotPasswordDTO;
import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.dto.UserDTO;
import com.upgrad.hirewheels.entites.User;
import com.upgrad.hirewheels.exceptions.GlobalExceptionHandler;
import com.upgrad.hirewheels.exceptions.RoleNotFoundException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.service.UserService;
import com.upgrad.hirewheels.util.DTOEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class AuthenticationController {
    @Autowired
    UserService userService;

    @Autowired
    DTOEntityMapper dtoEntityMapper;

    @PostMapping("/users")
    @ResponseBody
    public ResponseEntity userSignUp(@RequestBody UserDTO userDTO) throws GlobalExceptionHandler, RoleNotFoundException , UserAlreadyExistsException {
        ResponseEntity responseEntity = null;
        User newUser = dtoEntityMapper.convertUserDTOUser(userDTO);
        User functionReturn = userService.createUser(newUser);
        if (functionReturn != null) {
            CustomResponse response = new CustomResponse(new Date(), "User Successfully Signed Up", 200);
            responseEntity = new ResponseEntity(response, HttpStatus.OK);
        }
        else if (functionReturn.getFirstName().isEmpty()) {
            CustomResponse response = new CustomResponse(new Date(), "FirstName cannot be null or empty", 400);
            responseEntity = new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        else if (functionReturn.getPassword().isEmpty() || functionReturn.getPassword().length() < 5 ) {
            CustomResponse response = new CustomResponse(new Date(), "Password cannot be null or less than 5 characters", 400);
            responseEntity = new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        else if (functionReturn.getEmail().equals(userService.createUser(functionReturn)) || functionReturn.getMobileNumber().equals(userService.createUser(functionReturn))) {
            CustomResponse response = new CustomResponse(new Date(), "Mobile Number/Email already exists", 422);
            responseEntity = new ResponseEntity(response, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        else if (functionReturn.getMobileNumber().isEmpty() || functionReturn.getMobileNumber().length()< 10 ) {
            CustomResponse response = new CustomResponse(new Date(), "Mobile Number cannot be null or empty", 400);
            responseEntity = new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

//    @GetMapping("hirewheels/v1/users/access_token/")
//    public ResponseEntity userSignin(@RequestBody LoginDTO loginDTO){
//        ResponseEntity responseEntity = null;
//        User existingUser=dtoEntityMapper.convertUserDTOUser(loginDTO);
//        User functionalreturn = getUser(existingUser);
//    }


    @PutMapping("/users/password")
    @ResponseBody
    public ResponseEntity changePassword(@RequestBody ForgotPasswordDTO forgetpasswordDTO) throws Exception {
        ResponseEntity responseEntity = null;
        User functionReturn = userService.updatePassword(forgetpasswordDTO);
        if (functionReturn != null) {
            CustomResponse response = new CustomResponse(new Date(), "Password Successfully Changed", 200);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        return responseEntity;
    }
}
