package com.linkedin;

public class PowerXN {
    public static void main(String[] args) {
        double x = 2.0;
        int pow = 10;
        System.out.println(getPow(x, pow));
    }

    private static double getPow(double x, int pow) {
        if (pow < 0) {
            pow = -pow;
            x = 1/x;
        }
        double res = 1;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                res *= x;
            }
            x *= x;
            pow >>>= 1;
        }
        return res;
    }
}

/*
2 ^ -2
1/(2^2)
 */