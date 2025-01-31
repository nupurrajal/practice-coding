package com.linkedin;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindowSubstring(s, t));
    }

    private static String minWindowSubstring(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] tMap = new int[128];
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }
        int have = 0, need = 0, left = 0, right = 0, n = s.length(), i = -1, j = -1, minLen = Integer.MAX_VALUE;
        for (int ti : tMap) {
            if (ti > 0) {
                need++;
            }
        }
        int[] window = new int[128];
        while (right < n) {
            char c = s.charAt(right);
            window[c]++;
            if (tMap[c] > 0 && tMap[c] == window[c]) {
                have++;
            }
            while (have == need) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    i = left;
                    j = right;
                }
                char ch = s.charAt(left);
                window[ch]--;
                if (tMap[ch] > 0 && window[ch] < tMap[ch]) {
                    have--;
                }
                left++;
            }
            right++;
        }
        return i == -1 || j == -1 ? "" : s.substring(i, j+1);
    }
}
