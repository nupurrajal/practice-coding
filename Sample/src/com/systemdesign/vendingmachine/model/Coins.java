package com.systemdesign.vendingmachine.model;

public enum Coins {

    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
    private String value;

    Coins(int value) {

    }

    public int calculateChange(int amountGiven, int totalAmount) {

        return 0;
    }

}
