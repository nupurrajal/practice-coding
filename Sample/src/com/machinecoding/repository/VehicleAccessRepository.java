package com.machinecoding.repository;

import com.machinecoding.entity.Reservation;
import com.machinecoding.entity.Vehicle;
import com.machinecoding.types.VehicleType;

import java.util.Date;
import java.util.List;

public interface VehicleAccessRepository {

    public List<Vehicle> findByType(VehicleType type);


    // registration table
    public void confirmRegistration(String vehicleBarcode, Date startDate, Date dueDate, String userEmail, boolean status);


    // look in reservation table if the barcode / id exists with active status
    public List<Reservation> getVehicleByBarcode (String barcode);
}
