package com.machinecoding.sample.types;

import com.machinecoding.sample.utils.Constants;

public enum VehicleType {

    CAR(Constants.CAR_PER_HOUR), TRUCK(Constants.TRUCK_PER_HOUR), SUV(Constants.SUV_PER_HOUR), VAN(Constants.VAN_PER_HOUR), MOTORCYCLE(Constants.MOTORCYCLE_PER_HOUR);

    private double price;

    VehicleType(double cost) {
        this.price = cost;
    }

    public double getPrice() {
        return price;
    }
}
