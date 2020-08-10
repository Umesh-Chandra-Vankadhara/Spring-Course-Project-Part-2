package com.upgrad.hirewheels.dto;

import lombok.Data;

@Data
public class ResetPasswordDTO {
    String email;
    String oldPassword;
    String newPassword;
}
