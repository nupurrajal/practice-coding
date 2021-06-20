package com.test;

import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
//        try {
//            Float f = new Float(3.0);
//            int x = f.intValue();
//            byte b = f.byteValue();
//            double d = f.doubleValue();
//            System.out.println(x + b + d);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        Scanner s = new Scanner(System.in);
//        while (s.hasNext()) {
//            int i = s.nextInt();
//            System.out.println(i);
//        }
        String s1="a";
        String s2=s1;
        s1="b";
        System.out.println(s2==s1);
        System.out.println(-17%10);
        System.out.println(Integer.MAX_VALUE+1);
        Integer i = 0;
        System.out.println(i);

    }
}

interface S {
    void getS();
}

abstract class Pan implements S {

}

class BBP extends Pan {

    @Override
    public void getS() {

    }
}

class SDP extends BBP {

    void getS(String s) {
        try {
            Float f = new Float(3.0);
            int x = f.intValue();
            byte b = f.byteValue();
            double d = f.doubleValue();
            System.out.println(x + b + d);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
