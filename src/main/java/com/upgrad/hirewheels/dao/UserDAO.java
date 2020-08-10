package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userDAO")
public interface UserDAO extends JpaRepository<User ,Integer>{

    Optional<User> findByEmail(String email);
     Optional<User> findByMobileNumber(String mobileNumber);

     Optional<User> findByPassword(String password);
     User findByEmailAndPassword(String email,String password);





     // List<User> findAll();



}
