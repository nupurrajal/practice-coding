package com.test;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Temp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int i = 0, k = 0;
            StringBuilder res = new StringBuilder();
            while (k < str.length()) {
                if (str.charAt(k) >= 65 && str.charAt(k) <= 90) {
                    res.append(str.substring(i, k).toUpperCase());
                    res.append("_");
                    i = k;
                }
                k++;
            }
            res.append(str.substring(i).toUpperCase());
            System.out.println(res);
        }
        sc.close();
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
