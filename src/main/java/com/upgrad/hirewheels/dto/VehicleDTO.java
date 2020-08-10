package com.upgrad.hirewheels.dto;

import lombok.Data;

@Data
public class VehicleDTO {
     int vehicleId;
     int availablityStatus;
     String colour;
     String vehicleImageUrl;
     String vehicleModel;
     String vehicleNumber;
     int fuelTypeId;
     int locationId;
     int vehicleSubcategoryId;
}
