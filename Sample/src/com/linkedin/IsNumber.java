package com.linkedin;

public class IsNumber {
    public static void main(String[] args) {
        System.out.println(isNumber("005047e+6"));
    }

    public static boolean isNumber(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        boolean seenNum = false, seenE = false, seenDot = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch(ch) {
                case '.': if (seenE || seenDot) return false;
                    seenDot = true;
                    break;
                case 'e':
                case 'E': if (seenE || !seenNum) return false;
                    seenE = true;
                    seenNum = false;
                    break;
                case '+':
                case '-':
                    char p = s.charAt(i-1);
                    if (i != 0 && (s.charAt(i-1) != 'e' || s.charAt(i-1) != 'E')) return false;
                    seenNum = false;
                    break;
                default:
                    if (ch-'0' < 0 || ch-'0' > 9) return false;
                    seenNum = true;
            }
        }
        return seenNum;
    }
}
