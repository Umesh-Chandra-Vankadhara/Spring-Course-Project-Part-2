package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entites.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service(value = "initService")
public class InitServiceImpl implements InitService {

     @Autowired
     @Qualifier("userDAO")
     UserDAO userDAO;

     @Autowired
     @Qualifier("roleDAO")
     RoleDAO roleDAO;

     @Autowired
     @Qualifier("vehicleCategoryDAO")
     VehicleCategoryDAO vehicleCategoryDAO;

     @Autowired
     @Qualifier("vehicleSubcategoryDAO")
     VehicleSubcategoryDAO vehicleSubcategoryDAO;

     @Autowired
     @Qualifier("fuelTypeDAO")
     FuelTypeDAO fuelTypeDAO;

     @Autowired
     @Qualifier("cityDAO")
     CityDAO cityDAO;

     @Autowired
     @Qualifier("locationDAO")
     LocationDAO locationDAO;

    private static final Logger logger = LoggerFactory.getLogger(InitServiceImpl.class);


    @Override
    public void insertData() {
        insertUserRoles();
        insertUsers();
        insertCites();
        insertVehicleCategories();
        insertLocations();
        insertFuelTypes();
        insertVehicleSubcategories();

    }

    private void insertFuelTypes() {
        FuelType fuelType1=new FuelType();
        FuelType fuelType2=new FuelType();

        fuelType1.setFuelType("Petrol");
        fuelType2.setFuelType("Diesel");

        fuelTypeDAO.save(fuelType1);
        fuelTypeDAO.save(fuelType2);

    }

    private void insertLocations() {
        Location location1 =new Location();
        Location location2 =new Location();
        Location location3 =new Location();

        location1.setAddress("Dr E Moses Rd,Worli Naka,Upper Worli");
        location1.setPincode("400018");
        location1.setLocationName("Worli");
        location1.setCity(cityDAO.findByCityName("Mumbai"));

        location2.setAddress("Optic Complex");
        location2.setPincode("400019");
        location2.setLocationName("Chembur");
        location2.setCity(cityDAO.findByCityName("Mumbai"));


        location3.setAddress("Hiranandani Towers");
        location3.setPincode("400020");
        location3.setLocationName("Powai");
        location3.setCity(cityDAO.findByCityName("Mumbai"));

        locationDAO.save(location1);
        locationDAO.save(location2);
        locationDAO.save(location3);
    }

    private void insertVehicleSubcategories() {
        VehicleSubcategory vehicleSubcategory1 =new VehicleSubcategory();
        VehicleSubcategory vehicleSubcategory2=new VehicleSubcategory();
        VehicleSubcategory vehicleSubcategory3 =new VehicleSubcategory();
        VehicleSubcategory vehicleSubcategory4 =new VehicleSubcategory();
        VehicleSubcategory vehicleSubcategory5 =new VehicleSubcategory();
        VehicleSubcategory vehicleSubcategory6 =new VehicleSubcategory();

        vehicleSubcategory1.setCostPerHour(300);
        vehicleSubcategory1.setVehicleSubcategoryName("SUV");
        vehicleSubcategory1.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryName("Car"));

        vehicleSubcategory2.setCostPerHour(350);
        vehicleSubcategory2.setVehicleSubcategoryName("SEDAN");
        vehicleSubcategory2.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryName("Car"));


        vehicleSubcategory3.setCostPerHour(250);
        vehicleSubcategory3.setVehicleSubcategoryName("HATCHBACK");
        vehicleSubcategory3.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryName("Car"));


        vehicleSubcategory4.setCostPerHour(200);
        vehicleSubcategory4.setVehicleSubcategoryName("CRUSIER");
        vehicleSubcategory4.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryName("Car"));



        vehicleSubcategory5.setCostPerHour(200);
        vehicleSubcategory5.setVehicleSubcategoryName("DIRT BIKE");
        vehicleSubcategory5.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryName("Bike"));


        vehicleSubcategory6.setCostPerHour(150);
        vehicleSubcategory6.setVehicleSubcategoryName("SPORTS BIKE");
        vehicleSubcategory6.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryName("Bike"));


        vehicleSubcategoryDAO.save(vehicleSubcategory1);
        vehicleSubcategoryDAO.save(vehicleSubcategory2);
        vehicleSubcategoryDAO.save(vehicleSubcategory3);
        vehicleSubcategoryDAO.save(vehicleSubcategory4);
        vehicleSubcategoryDAO.save(vehicleSubcategory5);
        vehicleSubcategoryDAO.save(vehicleSubcategory6);


    }

    private void insertVehicleCategories() {
        VehicleCategory vehicleCategory1 =new VehicleCategory();
        VehicleCategory vehicleCategory2 =new VehicleCategory();

        vehicleCategory1.setVehicleCategoryId(10);
        vehicleCategory1.setVehicleCategoryName("Car");

        vehicleCategory2.setVehicleCategoryId(11);
        vehicleCategory2.setVehicleCategoryName("Bike");

        vehicleCategoryDAO.save(vehicleCategory1);
        vehicleCategoryDAO.save(vehicleCategory2);
    }


    private void insertUserRoles(){
        Role admin = new Role();
        admin.setRoleName("Admin");

        Role user = new Role();
        user.setRoleName("User");

        roleDAO.save(admin);
        roleDAO.save(user);
    }

    private void insertUsers() {
        User user = new User();

        user.setFirstName("Admin");
        user.setLastName("Admin");
        user.setEmail("admin@gmail.com");
        user.setMobileNumber("9999999999");
        user.setPassword("admin@123");
        user.setWalletMoney(10000);
        user.setRole(roleDAO.findByRoleName("Admin"));

        userDAO.save(user);

//        user.setFirstName("Ramesh");
//        user.setLastName("Gupta");
//        user.setEmail("ramesh@gmail.com");
//        user.setMobileNumber("9490397566");
//        user.setPassword("ramesh@123");
//        user.setWalletMoney(10000);
//        user.setRole(roleDAO.findByRoleName("User"));
//        userDAO.save(user);

    }


    private void insertCites() {
        City city=new City();

        city.setCityName("Mumbai");

        cityDAO.save(city);
    }




}

