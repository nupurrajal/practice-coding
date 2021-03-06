package com.machinecoding.sample.repository;

import com.machinecoding.sample.entity.Reservation;
import com.machinecoding.sample.entity.Vehicle;
import com.machinecoding.sample.types.VehicleType;

import java.util.Date;
import java.util.List;

public interface VehicleAccessRepository {

    public List<Vehicle> findByType(VehicleType type);


    // registration table
    public void confirmRegistration(String vehicleBarcode, Date startDate, Date dueDate, String userEmail, boolean status);


    // look in reservation table if the barcode / id exists with active status
    public List<Reservation> getVehicleByBarcode (String barcode);
}
