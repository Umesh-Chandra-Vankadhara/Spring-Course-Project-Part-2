package com.upgrad.hirewheels.entites;

import javax.persistence.*;

@Entity
@Table(name="VEHICLESUBCATEGORY")
public class VehicleSubcategory {
    @Id
    @SequenceGenerator(name="SUBCATEGORY_ID_GENERATOR" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUBCATEGORY_ID_GENERATOR")
    @Column(name="VEHICLE_SUBCATEGORY_ID")
    private int vehicleSubcategoryId;

    @Column(name="COST_PER_HOUR",nullable = false)
    private int costPerHour;

    @Column(name="VEHICLE_SUBCATEGORY_NAME",nullable = false,unique = true)
    private String vehicleSubcategoryName;

//    //bi-directional many-to-one association to Vehicle
//    @OneToMany(mappedBy="vehicleSubcategory")
//    private List<Vehicle> vehicles;

    //bi-directional many-to-one association to VehicleCategory
    @ManyToOne
    @JoinColumn(name="VEHICLE_CATEGORY_ID",nullable = false)
    private VehicleCategory vehicleCategory;

    public VehicleSubcategory() {
    }

    public VehicleSubcategory(int vehicleSubcategoryId,String vehicleSubcategoryName,int costPerHour ) {
        this.vehicleSubcategoryId=vehicleSubcategoryId ;
        this.vehicleSubcategoryName=vehicleSubcategoryName;
        this.costPerHour=costPerHour;
    }
    public VehicleSubcategory(String vehicleSubcategoryName,int costPerHour ){
        this.vehicleSubcategoryName=vehicleSubcategoryName;
        this.costPerHour=costPerHour;
    }


//    public VehicleSubcategory(int vehicleSubcategoryId, int costPerHour, String vehicleSubcategoryName, List<Vehicle> vehicles, VehicleCategory vehicleCategory) {
//        this.vehicleSubcategoryId = vehicleSubcategoryId;
//        this.costPerHour = costPerHour;
//        this.vehicleSubcategoryName = vehicleSubcategoryName;
//        this.vehicles = vehicles;
//        this.vehicleCategory = vehicleCategory;
//    }

    public int getVehicleSubcategoryId() {
        return this.vehicleSubcategoryId;
    }

    public void setVehicleSubcategoryId(int vehicleSubcategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }

    public double getCostPerHour() {
        return this.costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public String getVehicleSubcategoryName() {
        return this.vehicleSubcategoryName;
    }

    public void setVehicleSubcategoryName(String vehicleSubcategoryName) {
        this.vehicleSubcategoryName = vehicleSubcategoryName;
    }

    public VehicleCategory getVehicleCategory() {
        return this.vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
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
//        vehicle.setVehicleSubcategory(this);
//
//        return vehicle;
//    }
//
//    public Vehicle removeVehicle(Vehicle vehicle) {
//        getVehicles().remove(vehicle);
//        vehicle.setVehicleSubcategory(null);
//
//        return vehicle;
//    }


    @Override
    public String toString() {
        return "VehicleSubcategory{" +
                "vehicleSubcategoryId=" + vehicleSubcategoryId +
                ", costPerHour=" + costPerHour +
                ", vehicleSubcategoryName='" + vehicleSubcategoryName + '\'' +
                ", vehicleCategory=" + vehicleCategory +
                '}';
    }

//    @Override
//    public String toString() {
//        return "VehicleSubcategory{" +
//                "vehicleSubcategoryId=" + vehicleSubcategoryId +
//                ", costPerHour=" + costPerHour +
//                ", vehicleSubcategoryName='" + vehicleSubcategoryName + '\'' +
//                '}';
//    }


}
