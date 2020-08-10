package com.upgrad.hirewheels.entites;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @SequenceGenerator(name="VEHICLE_VEHICLEID_GENERATOR" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VEHICLE_VEHICLEID_GENERATOR")
    @Column(name="VEHICLE_ID")
    private int vehicleId;

    @Column(name="AVAILABLITY_STATUS" ,nullable =false )
    @ColumnDefault("1")
    private int availablityStatus;

    @Column(nullable =false )
    private String colour;

    @Column(name="VEHICLE_IMAGE_URL",nullable =false)
    private String vehicleImageUrl;

    @Column(name="VEHICLE_MODEL",nullable =false)
    private String vehicleModel;

    @Column(name="VEHICLE_NUMBER",nullable =false)
    private String vehicleNumber;

    //bi-directional many-to-one association to FuelType
    @ManyToOne
    @JoinColumn(name="FUEL_TYPE_ID",nullable =false)
    private FuelType fuelType;

    //bi-directional many-to-one association to Location
    @ManyToOne
    @JoinColumn(name="LOCATION_ID",nullable =false)
    private Location location;

    //bi-directional many-to-one association to VehicleSubcategory
    @ManyToOne
    @JoinColumn(name="VEHICLE_SUBCATEGORY_ID")
    private VehicleSubcategory vehicleSubcategory;

    public Vehicle() {
    }

    public Vehicle(int vehicleId, int availablityStatus, String colour, String vehicleImageUrl, String vehicleModel, String vehicleNumber, FuelType fuelType, Location location, VehicleSubcategory vehicleSubcategory) {
        this.vehicleId = vehicleId;
        this.availablityStatus = availablityStatus;
        this.colour = colour;
        this.vehicleImageUrl = vehicleImageUrl;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.fuelType = fuelType;
        this.location = location;
        this.vehicleSubcategory = vehicleSubcategory;
    }

    public Vehicle(int availablityStatus, String colour, String vehicleImageUrl, String vehicleModel, String vehicleNumber, FuelType fuelType, Location location, VehicleSubcategory vehicleSubcategory) {

        this.availablityStatus = availablityStatus;
        this.colour = colour;
        this.vehicleImageUrl = vehicleImageUrl;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.fuelType = fuelType;
        this.location = location;
        this.vehicleSubcategory = vehicleSubcategory;
    }

    public Vehicle(int availablityStatus,  String colour, String vehicleImageUrl, String vehicleModel, String vehicleNumber) {
        this.availablityStatus=availablityStatus;
        this.colour = colour;
        this.vehicleImageUrl = vehicleImageUrl;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
    }

    public Vehicle(  String colour, String vehicleImageUrl, String vehicleModel, String vehicleNumber) {
        this.colour = colour;
        this.vehicleImageUrl = vehicleImageUrl;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
    }

    public int getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getAvailablityStatus() {
        return this.availablityStatus;
    }

    public void setAvailablityStatus(int availablityStatus) {
        this.availablityStatus = availablityStatus;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getVehicleImageUrl() {
        return this.vehicleImageUrl;
    }

    public void setVehicleImageUrl(String vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }

    public String getVehicleModel() {
        return this.vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public VehicleSubcategory getVehicleSubcategory() {
        return this.vehicleSubcategory;
    }

    public void setVehicleSubcategory(VehicleSubcategory vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", availablityStatus=" + availablityStatus +
                ", colour='" + colour + '\'' +
                ", vehicleImageUrl='" + vehicleImageUrl + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", fuelType=" + fuelType +
                ", location=" + location +
                ", vehicleSubcategory=" + vehicleSubcategory +
                '}';
    }
}
