package com.designpattern.strategy;

public class Duck {

    IFlyBehaviour flyBehaviour;
    IDisplayBehaviour displayBehaviour;
    IQuackBehaviour quackBehaviour;

    public Duck(IFlyBehaviour fb, IDisplayBehaviour db, IQuackBehaviour qb) {
        this.flyBehaviour = fb;
        this.displayBehaviour = db;
        this.quackBehaviour = qb;
    }

    public void fly() {
        this.flyBehaviour.fly();
    }

    public void display() {
        this.displayBehaviour.display();
    }

    public void quack() {
        this.quackBehaviour.quack();
    }

}
