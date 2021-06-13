package com.designpattern.observer;

import java.util.List;

public class WeatherStation implements ISubject{

    List<ISubscriber> listOfObservers;

    float temperature;

    @Override
    public void add(ISubscriber subscriber) {
        this.listOfObservers.add(subscriber);
    }

    @Override
    public void remove(ISubscriber subscriber) {
        this.listOfObservers.remove(subscriber);
    }

    @Override
    public void notifyAllSubs() {
        for (ISubscriber subscriber : this.listOfObservers) {
            subscriber.update();
        }
    }

    public float getTemperature() {
        return temperature;
    }
}
