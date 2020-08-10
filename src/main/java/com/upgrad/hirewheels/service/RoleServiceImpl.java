package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.RoleDAO;
import com.upgrad.hirewheels.entites.Role;
import com.upgrad.hirewheels.exceptions.RoleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements  RoleService {
    @Autowired
    @Qualifier("userRoleDAO")
    RoleDAO userRoleDAO;

    @Override
    public Role acceptUserRoleDetails(Role role) {
        return userRoleDAO.save(role);
    }

    @Override
    public Role findUserRoleDetails(int RoleId) throws RoleNotFoundException {
        Role savedUserRole = userRoleDAO.findById(RoleId).get();
        if(savedUserRole == null){
            throw  new RoleNotFoundException("User role not found for id : " + RoleId);
        }
        return  savedUserRole;
}
}
