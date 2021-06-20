package com.practice.bitmanipulation;

import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.close();
    }

    private static int setIthBit(int n, int i) {
        return n | (i<<1);
    }

    private static boolean checkIthBitSet(int n, int i) {
        return (n | (i << 1)) == 0 ? true : false;
    }

    private static int resetIthBit(int n, int i) {
        return n & (~(1 << i));
    }

    private static int toggleIthBit(int n, int i) {
        return n ^ (1 << i);
    }

    private static boolean checkParity(int n) {
        // check if lsb is set to 1, even or odd.
        return (n & 1) == 0 ? true : false;
    }

    private static int removeRightmostSetBit(int n) {
        return n & (n-1);
    }

    private static boolean checkIfPowerOfTwo(int n) {
        return (n & (n-1)) == 0 ? true : false;
    }

    private static int countNumberOfSetBits(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1<<i)) != 0) {
                count++;
            }
        }

        /*
        method 2
         */
        int temp = n;
        int count2 = 0;
        while (temp != 0) {
            count2++;
            temp = temp & (temp-1);
        }
        return count;
    }
}
