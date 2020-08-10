package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dto.ForgotPasswordDTO;
import com.upgrad.hirewheels.entites.User;
import com.upgrad.hirewheels.exceptions.CustomException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService{
           User createUser(User user) throws UserAlreadyExistsException;

           User updatePassword(ForgotPasswordDTO forgetpasswordDTO);
           UserDetails loadUserDetails(String username) throws UserNotFoundException;
            User getUser(String email, String password) throws CustomException;

}
