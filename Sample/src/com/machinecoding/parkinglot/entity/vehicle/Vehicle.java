package com.machinecoding.parkinglot.entity.vehicle;

import com.machinecoding.parkinglot.entity.parking.ParkingTicket;

import java.util.Random;

public abstract class Vehicle {
    private String licensePlateNo;
    private final VehicleType type;
    private ParkingTicket parkingTicket;

    Vehicle(String licensePlateNo, VehicleType type) {
        this.licensePlateNo = licensePlateNo;
        this.type = type;
    }
}
