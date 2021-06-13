package com.systemdesign.vendingmachine.model;

public interface State {

    void placeOrder();

    void cancelOrder();
}
