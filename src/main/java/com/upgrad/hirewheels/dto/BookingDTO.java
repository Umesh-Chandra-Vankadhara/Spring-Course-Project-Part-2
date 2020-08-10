package com.upgrad.hirewheels.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.upgrad.hirewheels.entites.Location;
import com.upgrad.hirewheels.entites.User;
import com.upgrad.hirewheels.entites.Vehicle;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class BookingDTO {
     long bookingId;

     double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
     Date bookingDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
     Date dropoffDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
     Date pickupDate;

     Location locationId;

     User userId;

     Vehicle vehicleId;

}
