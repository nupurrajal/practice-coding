package com.test;

import java.io.*;
import java.util.Scanner;

public class Temp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
        change(s1);
        System.out.println(s1);
//        String s2=s1;
//        s1="b";
//        System.out.println(s2==s1);
//        System.out.println(-17%10);
//        System.out.println(Integer.MAX_VALUE+1);
//        Integer l = 0;
//        System.out.println(l);

//        int res = 4;
//        for (int i = 5; i <=8; i++) {
//            res = res ^ i;
//        }
//        System.out.println("res = " + res);
//        System.out.println(-3%4);
//
//
//        Test input = new Test();
//
//        // serialization
//        FileOutputStream fos = new FileOutputStream("../abc.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(input);
//
//        // de-serialization
//        FileInputStream fis = new FileInputStream("../abc.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Test output = (Test)ois.readObject();
//        System.out.println("i = " + output.i);
//        System.out.println("j = " + output.j);
//        System.out.println("k = " + output.k);
//        System.out.println("l = " + output.l);
//        System.out.println("m = " + output.m);
    }

    public static void main(char args) {
        System.out.println("ooo");

    }

    private static
    void change(String s) {
        s="ddd";
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

class Test implements Serializable
{
    // Normal variables
    int i = 10, j = 20;

    // Transient variables
    transient int k = 30;

    // Use of transient has no impact here
    transient static int l = 40;
    transient final int m = 50;

//    public static void main(String[] args) throws Exception
//    {
//        Test input = new Test();
//
//        // serialization
//        FileOutputStream fos = new FileOutputStream("../abc.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(input);
//
//        // de-serialization
//        FileInputStream fis = new FileInputStream("../abc.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Test output = (Test)ois.readObject();
//        System.out.println("i = " + output.i);
//        System.out.println("j = " + output.j);
//        System.out.println("k = " + output.k);
//        System.out.println("l = " + output.l);
//        System.out.println("m = " + output.m);
//    }
}
