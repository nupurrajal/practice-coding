package com.test;

import java.util.Scanner;

public class SwapWithoutTemp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("a = " + a + ", b = " + b);
            a = a - b;
            b = a + b;
            a = b - a;
            System.out.println("a = " + a + ", b = " + b);
        }
//        sc.close();
    }
}
