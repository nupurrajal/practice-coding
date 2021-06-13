package com.designpattern.observer;

public class PhoneDisplay implements ISubscriber {

    WeatherStation weatherStation;
    PhoneDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        this.weatherStation.getTemperature();
    }
}
