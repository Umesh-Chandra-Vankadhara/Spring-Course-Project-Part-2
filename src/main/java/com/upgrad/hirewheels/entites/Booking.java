package com.upgrad.hirewheels.entites;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @SequenceGenerator(name="BOOKING_ID_GENERATOR" )
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="BOOKING_ID_GENERATOR")
    @Column(name="BOOKING_ID")
    private long bookingId;

    @Column(nullable =false)
    private double amount;

    @Column(name="BOOKING_DATE",nullable = false)
    private Date bookingDate;

    @Column(name="DROPOFF_DATE",nullable = false)
    private Date dropoffDate;

    @Column(name="PICKUP_DATE",nullable = false)
    private Date pickupDate;

    //bi-directional many-to-one association to Location
    @ManyToOne
    @JoinColumn(name="LOCATION_ID",nullable = false)
    private Location location;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="USER_ID",nullable = false)
    private User user;

    //bi-directional many-to-one association to Vehicle
    @ManyToOne
    @JoinColumn(name="VEHICLE_ID",nullable = false)
    private Vehicle vehicle;

    public Booking() {
    }

    public Booking(double amount, Date bookingDate, Date dropoffDate, Date pickupDate, Location location, User user, Vehicle vehicle) {
        this.amount = amount;
        this.bookingDate = bookingDate;
        this.dropoffDate = dropoffDate;
        this.pickupDate = pickupDate;
        this.location = location;
        this.user = user;
        this.vehicle = vehicle;
    }

    public Booking(double amount, Date bookingDate, Date dropoffDate, Date pickupDate) {
        this.amount = amount;
        this.bookingDate = bookingDate;
        this.dropoffDate = dropoffDate;
        this.pickupDate = pickupDate;
    }

    public long getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getBookingDate() {
        return this.bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getDropoffDate() {
        return this.dropoffDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public Date getPickupDate() {
        return this.pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", amount=" + amount +
                ", bookingDate=" + bookingDate +
                ", dropoffDate=" + dropoffDate +
                ", location=" + location +
                ", pickupDate=" + pickupDate +
                ", user=" + user +
                ", vehicle=" + vehicle +
                '}';
    }
}