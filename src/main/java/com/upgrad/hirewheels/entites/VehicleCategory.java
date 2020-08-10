package com.upgrad.hirewheels.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLECATEGORY")
public class VehicleCategory {

    @Id
//    @SequenceGenerator(name="VEHICLE_CATEGORY_VEHICLECATEGORYID_GENERATOR" )
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VEHICLE_CATEGORY_VEHICLECATEGORYID_GENERATOR")
    @Column(name="VEHICLE_CATEGORY_ID")
    private int vehicleCategoryId;

    @Column(name="VEHICLE_CATEGORY_NAME",nullable = false,unique = true)
    private String vehicleCategoryName;

//    //bi-directional many-to-one association to VehicleSubcategory
//    @OneToMany(mappedBy="vehicleCategory")
//    private List<VehicleSubcategory> vehicleSubcategories;

    public VehicleCategory() {
    }

    public VehicleCategory(int vehicleCategoryId,String vehicleCategoryName) {
        this.vehicleCategoryId=vehicleCategoryId;
        this.vehicleCategoryName=vehicleCategoryName;

    }

    public VehicleCategory(String vehicleCategoryName) {

        this.vehicleCategoryName=vehicleCategoryName;

    }

    public int getVehicleCategoryId() {
        return this.vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return this.vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }
//
//    public List<VehicleSubcategory> getVehicleSubcategories() {
//        return this.vehicleSubcategories;
//    }
//
//    public void setVehicleSubcategories(List<VehicleSubcategory> vehicleSubcategories) {
//        this.vehicleSubcategories = vehicleSubcategories;
//    }
//
//    public VehicleSubcategory addVehicleSubcategory(VehicleSubcategory vehicleSubcategory) {
//        getVehicleSubcategories().add(vehicleSubcategory);
//        vehicleSubcategory.setVehicleCategory(this);
//
//        return vehicleSubcategory;
//    }
//
//    public VehicleSubcategory removeVehicleSubcategory(VehicleSubcategory vehicleSubcategory) {
//        getVehicleSubcategories().remove(vehicleSubcategory);
//        vehicleSubcategory.setVehicleCategory(null);
//
//        return vehicleSubcategory;
//    }

    @Override
    public String toString() {
        return "VehicleCategory{" +
                "vehicleCategoryId=" + vehicleCategoryId +
                ", vehicleCategoryName='" + vehicleCategoryName + '\'' +
               // ", vehicleSubcategories=" + vehicleSubcategories +
                '}';
    }
}
