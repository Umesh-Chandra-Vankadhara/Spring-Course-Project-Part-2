package com.upgrad.hirewheels.entites;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @SequenceGenerator(name="LOCATION_LOCATIONID_GENERATOR" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATION_LOCATIONID_GENERATOR")
    @Column(name="LOCATION_ID")
    private int locationId;

    @Column(nullable = false)
    private String address;

    @Column(name="LOCATION_NAME",nullable =false)
    private String locationName;

    @Column(nullable = false)
    private String pincode;

    //bi-directional many-to-one association to City
    @ManyToOne
    @JoinColumn(name="CITY_ID",nullable = false)
    private City city;

//    //bi-directional many-to-one association to Vehicle
//    @OneToMany(mappedBy="location")
//    private List<Vehicle> vehicles;

    public Location() {
    }

    public Location( String address, String locationName, String pincode, City city) {
        this.address = address;
        this.locationName = locationName;
        this.pincode = pincode;
        this.city = city;
    }

    public Location( String address, String locationName, String pincode) {

        this.address = address;
        this.locationName = locationName;
        this.pincode = pincode;
    }

    public int getLocationId() {
        return this.locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

//    public List<Vehicle> getVehicles() {
//        return this.vehicles;
//    }
//
//    public void setVehicles(List<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }
//
//    public Vehicle addVehicle(Vehicle vehicle) {
//        getVehicles().add(vehicle);
//        vehicle.setLocation(this);
//
//        return vehicle;
//    }

//    public Vehicle removeVehicle(Vehicle vehicle) {
//        getVehicles().remove(vehicle);
//        vehicle.setLocation(null);
//
//        return vehicle;
//    }
//
//    @Override
//    public String toString() {
//        return "Location{" +
//                "locationId=" + locationId +
//                ", address='" + address + '\'' +
//                ", locationName='" + locationName + '\'' +
//                ", pincode='" + pincode + '\'' +
//                ", city=" + city +
//                ", vehicles=" + vehicles +
//                '}';
//    }
//
    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", address='" + address + '\'' +
                ", locationName='" + locationName + '\'' +
                ", pincode='" + pincode + '\'' +
                ", city=" + city +
                '}';
    }
//
//    @Override
//    public String toString() {
//        return "Location{" +
//                "locationId=" + locationId +
//                ", address='" + address + '\'' +
//                ", locationName='" + locationName + '\'' +
//                ", pincode='" + pincode + '\'' +
//                '}';
//    }
}
