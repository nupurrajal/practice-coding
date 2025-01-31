package com.linkedin;

public class IntegerToRoman {

    static int[] intValues = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        int num = 3749;
        System.out.println(getRomanOfInt(num));
    }

    private static String getRomanOfInt(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < intValues.length; i++) {
            while (num >= intValues[i]) {
                num -= intValues[i];
                result.append(romans[i]);
            }
        }
        return result.toString();
    }
}
