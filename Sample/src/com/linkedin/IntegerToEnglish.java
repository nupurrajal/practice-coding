package com.linkedin;

public class IntegerToEnglish {
    static String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static void main(String[] args) {
        int number = 3847129;
        System.out.println(getStringValueOfInteger(number));
    }

    private static String getStringValueOfInteger(int number) {
        if (number == 0) {
            return "Zero";
        }
        if (number < 10) {
            return belowTen[number];
        }
        if (number < 20) {
            return belowTwenty[number-10];
        }
        if (number < 100) {
            return belowHundred[number / 10] + (number % 10 != 0 ? " " + getStringValueOfInteger(number % 10) : "");
        }
        if (number < 1000) {
            return getStringValueOfInteger(number / 100) + " Hundred" + (number % 100 != 0 ? " " + getStringValueOfInteger(number % 100) : "");
        }
        if (number < 1000000) {
            return getStringValueOfInteger(number / 1000) + " Thousand" + (number % 1000 != 0 ?  " " + getStringValueOfInteger(number % 1000) : "");
        }
        if (number < 1000000000) {
            return getStringValueOfInteger(number / 1000000) + " Million" + (number % 1000000 != 0 ? " " + getStringValueOfInteger(number % 1000000) : "");
        }
        return getStringValueOfInteger(number / 1000000000) + " Billion" + (number % 1000000000 != 0 ? " " + getStringValueOfInteger(number % 1000000000) : "");

    }
}
