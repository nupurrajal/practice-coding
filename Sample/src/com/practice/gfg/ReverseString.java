package com.practice.gfg;

public class ReverseString {
    static String reverseWords(String S)
    {
        // code here
        if (S.length() == 0)
            return S;
        StringBuilder result = new StringBuilder();
        String[] components = S.split("\\.");
        for (int i = components.length - 1; i > 0; i--) {
            result.append(components[i]);
            result.append(".");
        }
        result.append(components[0]);
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "n.p";
        System.out.println(reverseWords(s));
    }
}
