package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleDAO")
public interface RoleDAO extends JpaRepository<Role,Integer> {
    Role findByRoleName(String role);
}
