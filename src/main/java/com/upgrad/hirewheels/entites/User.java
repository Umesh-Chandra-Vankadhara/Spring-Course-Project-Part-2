package com.upgrad.hirewheels.entites;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(name="USERS_USERID_GENERATOR" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_USERID_GENERATOR")
    @Column(name="USER_ID")
    private int userId;

    @Column(nullable=false,unique=true)
    private String email;

    @Column(name="FIRST_NAME",nullable=false)
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="MOBILE_Number",nullable=false,unique = true)
    private String mobileNumber;

    @Column(nullable=false)
    private String password;

    @ManyToOne
    @JoinColumn(name="ROLE_ID",nullable=false)
    private Role role;

    @Column(name="WALLET_MONEY")
    @ColumnDefault("10000.00")
    private double walletMoney;

    public User() {
    }


    public User(int  userId, String firstName, String lastName, String email, String password, Role role, String mobileNumber, double walletMoney) {
    this.userId=userId ;
    this.firstName=firstName;
    this.lastName=lastName;
    this.email=email;
    this.password=password;
    this.role=role;
    this.mobileNumber=mobileNumber;
    this.walletMoney=walletMoney;
    }


    public User(String firstName,String lastName,String email,String password,String mobileNumber,double walletMoney) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
        this.mobileNumber=mobileNumber;
        this.walletMoney=walletMoney;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", walletMoney=" + walletMoney +
                '}';
    }



}
