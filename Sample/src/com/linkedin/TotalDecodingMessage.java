package com.linkedin;

public class TotalDecodingMessage {
    public static void main(String[] args) {
        String s = "90";
//        System.out.println(findTotalDecodingMessageBottomUp(s));
        System.out.println(findTotalDecodingMessageRecursion(s, 0));
    }

    private static int findTotalDecodingMessageRecursion(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        int singleDigit = findTotalDecodingMessageRecursion(s, index+1);
        int doubleDigit = 0;
        if (index < s.length()-1) {
            int i = Integer.parseInt(s.substring(index, index + 2));
            if (i >= 10 && i < 27) {
                doubleDigit = findTotalDecodingMessageRecursion(s, index+2);
            }
        }

        return singleDigit + doubleDigit;
    }

    private static int findTotalDecodingMessageBottomUp(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            int num = Integer.valueOf(s.substring(i - 2, i));
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

}
