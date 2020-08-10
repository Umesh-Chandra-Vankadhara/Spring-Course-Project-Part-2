package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dao.UserDAO;
import com.upgrad.hirewheels.dto.ForgotPasswordDTO;
import com.upgrad.hirewheels.entites.User;
import com.upgrad.hirewheels.exceptions.CustomException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.upgrad.hirewheels.exceptions.UnauthourizedUserException;
//import com.upgrad.hirewheels.exceptions.UserNotRegisteredException;

@Service(value="userService")
public class UserServiceImpl implements  UserService {
    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;

    private Map<String, User> refreshTokenUserMap;

    private List<String> tokenStore;

    private Map<String, String> refreshTokenAccessTokenMap;

    private Map<String, User> accessTokenUserMap;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @PostConstruct
    public void init() {
        refreshTokenUserMap = new HashMap<>();
        tokenStore = new ArrayList<>();
        refreshTokenAccessTokenMap = new HashMap<>();
        accessTokenUserMap = new HashMap<>();
    }

    public void updateAccessTokenUserMap(String accessTokenPrev, String accessTokenNew, User customerUser) {
        if (accessTokenUserMap.containsKey(accessTokenPrev)) {
            User user = accessTokenUserMap.get(accessTokenPrev);
            accessTokenUserMap.remove(accessTokenPrev);
            accessTokenUserMap.put(accessTokenNew, user);
        } else {
            accessTokenUserMap.put(accessTokenNew, customerUser);
        }
    }

    public User getUserFromAccessToken(String accessToken) {
        return accessTokenUserMap.get(accessToken);
    }


    public void removeUserFromAccessTokenMap(String accessToken) {
        if (accessTokenUserMap.containsKey(accessToken)) {
            accessTokenUserMap.remove(accessToken);
        }
    }

    public boolean isTokenPresent(String token) {
        return tokenStore.contains(token);
    }

    public void removeTokenIfPresent(String token) {
        if (tokenStore.contains(token)) {
            tokenStore.remove(token);
        }
    }

    public void updateRefreshTokenAccessTokenMap(String refreshToken, String accessToken) {
        this.refreshTokenAccessTokenMap.put(refreshToken, accessToken);
    }

    public void removeRefreshTokenAccessTokenMap(String refreshToken) {
        if (this.refreshTokenAccessTokenMap.containsKey(refreshToken)) {
            this.refreshTokenAccessTokenMap.remove(refreshToken);
        }
    }

    public String getCurrentAccessTokenFromRefreshToken(String refreshToken) {
        return this.refreshTokenAccessTokenMap.get(refreshToken);
    }

    public void addToken(String token) {
        tokenStore.add(token);
    }

    public void removeRefreshToken(String refreshToken) {
        if (refreshTokenUserMap.containsKey(refreshToken)) {
            refreshTokenUserMap.remove(refreshToken);
        }
    }

    public User getUserfromRefreshToken(String refreshToken) {
        return refreshTokenUserMap.get(refreshToken);
    }

    public String getRefreshTokenForUser(String email) {

        User customerUser = null;
        List<User> customers = getAllUserDetails();
        for (User user : customers) {
            if (user.getEmail().equals(email)) {
                customerUser = user;
                break;
            }
        }

        if (customerUser == null) { //User is not present
            return null;
        }
        for (Map.Entry<String, User> entry : refreshTokenUserMap.entrySet()) {
            if (entry.getValue().equals(customerUser)) {
                return entry.getKey();
            }
        }

        return null;
    }

    private List<User> getAllUserDetails() {
    return userDAO.findAll();
    }

    public void addRefreshToken(String refreshToken, User user) {
        this.refreshTokenUserMap.put(refreshToken, user);
    }

    @Override
    public User createUser(User user) throws UserAlreadyExistsException {
        logger.debug("Entered acceptUserDetails", user);
        if (userDAO.findByEmail(user.getEmail()).isPresent())
            throw new UserAlreadyExistsException("EmailAlreadyExists:" + user.getEmail());
        else if (userDAO.findByMobileNumber(user.getMobileNumber()).isPresent())
            throw new UserAlreadyExistsException("MobileNumberAlreadyExists:" + user.getMobileNumber());
        return userDAO.save(user);

    }

    @Override
    public User updatePassword(ForgotPasswordDTO forgetpasswordDTO) {
        return null;
    }

    @Override
    public UserDetails loadUserDetails(String email) throws UserNotFoundException {
        User user = userDAO.findByEmail(email).orElseThrow(
                ()->  new UserNotFoundException("user  not found for " + email));

        return  new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword() , new ArrayList<>());

    }

    @Override
    public User getUser(String email, String password) throws CustomException,NullPointerException {
        logger.debug("get user details", email, password);
        System.out.println("Get User details ");
        User user = userDAO.findByEmailAndPassword(email, password);
        if (userDAO.findByEmail(email).isEmpty())
            throw new CustomException("UserNotRegistered for email:" + " " + email);
        else if (user.getEmail().equals(userDAO.findByEmail(email)) && (!user.getPassword().equals(userDAO.findByPassword(password))))
            throw new CustomException("Unauthorized User");
        else if (user.getEmail().equals(userDAO.findByEmail(email)) && (user.getPassword().equals(userDAO.findByPassword(password))))
            return user;

        else
            return user;

    }
}