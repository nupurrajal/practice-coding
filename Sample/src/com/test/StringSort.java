package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class StringSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        sortString(s1);
    }

    private static void sortString(String s1) {
        List<Character> sinchar = s1.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        Collections.sort(sinchar, new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                if (!Character.isAlphabetic(o1) && !Character.isAlphabetic(o2))
                    return 0;
                if (!Character.isAlphabetic(o1))
                    return 1;
                if (!Character.isAlphabetic(o2))
                    return -1;
                return o1-o2;
            }
        });
        System.out.println(sinchar);
    }
}
