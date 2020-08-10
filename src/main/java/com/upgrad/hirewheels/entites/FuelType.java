package com.upgrad.hirewheels.entites;

import javax.persistence.*;
import java.util.List;

@Entity
public class FuelType {

    @Id
    @SequenceGenerator(name="FUEL_TYPE_ID_GENERATOR" )
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="FUEL_TYPE_ID_GENERATOR")
    @Column(name="FUEL_TYPE_ID")
    private int fuelTypeId;

    @Column(name="FUEL_TYPE",nullable = false,unique = true)
    private String fuelType;

    //bi-directional many-to-one association to Vehicle
    @OneToMany(mappedBy="fuelType")
    private List<Vehicle> vehicles;

    public FuelType() {
    }

    public FuelType(int fuelTypeId, String fuelType) {
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;

    }

    public int getFuelTypeId() {
        return this.fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        getVehicles().add(vehicle);
        vehicle.setFuelType(this);

        return vehicle;
    }

    public Vehicle removeVehicle(Vehicle vehicle) {
        getVehicles().remove(vehicle);
        vehicle.setFuelType(null);

        return vehicle;
    }

//    @Override
//    public String toString() {
//        return "FuelType{" +
//                "fuelTypeId=" + fuelTypeId +
//                ", fuelType='" + fuelType + '\'' +
//                ", vehicles=" + vehicles +
//                '}';
//    }

    @Override
    public String toString() {
        return "FuelType{" +
                "fuelTypeId=" + fuelTypeId +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
