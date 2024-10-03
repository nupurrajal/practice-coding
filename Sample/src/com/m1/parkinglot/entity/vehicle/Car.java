package com.machinecoding.parkinglot.entity.vehicle;

public class Car extends Vehicle {
    public Car(String licenseNo) {
        super(licenseNo, VehicleType.CAR);
    }
}
