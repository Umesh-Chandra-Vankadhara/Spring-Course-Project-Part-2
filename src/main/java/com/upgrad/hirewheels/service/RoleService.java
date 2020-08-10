package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entites.Role;
import com.upgrad.hirewheels.exceptions.RoleNotFoundException;

public interface RoleService {
    Role acceptUserRoleDetails(Role role);
    Role findUserRoleDetails(int userRoleId) throws RoleNotFoundException;
}
