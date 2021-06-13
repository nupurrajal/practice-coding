package com.designpattern.observer;

public interface ISubject {

    void add (ISubscriber subscriber);
    void remove (ISubscriber subscriber);
    void notifyAllSubs();

}
