package com.upgrad.hirewheels.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    int userId;
    String firstName;
    String lastName;
    String email;
    String password;
    String mobileNumber;
    int walletMoney;
    int RoleId;
//    String jwtToken;
//    String refreshToken;
    List<Integer> bookingIds;

}
