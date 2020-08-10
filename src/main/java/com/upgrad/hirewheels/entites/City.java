package com.upgrad.hirewheels.entites;

import javax.persistence.*;
import java.util.List;


@Entity
public class City {
    @Id
    @SequenceGenerator(name="CITY_ID_GENERATOR" )
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="CITY_ID_GENERATOR")
    @Column(name="CITY_ID")
    private int cityId;

    @Column(name="CITY_NAME",nullable = false)
    private String cityName;

    //bi-directional many-to-one association to Location
    @OneToMany(mappedBy="city")
    private List<Location> locations;

    public City() {
    }

    public City(int cityId) {
        this.cityId = cityId;
    }

    public City(int cityId, String cityName, List<Location> locations) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.locations = locations;
    }

    public City(String cityName) {
        this.cityName = cityName;

    }

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public int getCityId() {
        return this.cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Location> getLocations() {
        return this.locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Location addLocation(Location location) {
        getLocations().add(location);
        location.setCity(this);

        return location;
    }

    public Location removeLocation(Location location) {
        getLocations().remove(location);
        location.setCity(null);

        return location;
    }

//    @Override
//    public String toString() {
//        return "City{" +
//                "cityId=" + cityId +
//                ", cityName='" + cityName + '\'' +
//                ", locations=" + locations +
//                '}';
//    }

//    @Override
//    public String toString() {
//        return "City{" +
//               "cityId=" + cityId +
//                ", cityName='" + cityName + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return  cityName;
    }
}
