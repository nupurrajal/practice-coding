package com.linkedin;

public class FindTheCelebrity {

    CheckCeleb checkCeleb;
    public static void main(String[] args) {

    }

    private int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (this.checkCeleb.knows(celebrity, i)) {
                celebrity = i;
            }
        }
        for (int i = 1; i < n; i++) {
            if (i != celebrity) {
                if (this.checkCeleb.knows(celebrity, i) && !this.checkCeleb.knows(i, celebrity)) {
                    return -1;
                }
            }
        }
        return celebrity;
    }
}

interface CheckCeleb {
    boolean knows(int a, int b);
}