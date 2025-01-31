package com.linkedin;

public class NumberOfFactors {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(noOfFactorsOfN(N, 1));
    }

    private static int noOfFactorsOfN(int n, int div) {
        if (div > Math.sqrt(n)) {
            return 0;
        }
        if (n % div == 0) {
            if (div != n / div) {
                return 2 + noOfFactorsOfN(n, div+1);
            } else {
                return 1 + noOfFactorsOfN(n, div+1);
            }
        }
        return noOfFactorsOfN(n, div+1);
    }
}
