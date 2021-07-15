package com.machinecoding.whjr.entity;

public class Vehicle {

    private int id;
    private String barcode;
    private ParkingStall parkingStall;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public ParkingStall getParkingStall() {
        return parkingStall;
    }

    public void setParkingStall(ParkingStall parkingStall) {
        this.parkingStall = parkingStall;
    }

}
