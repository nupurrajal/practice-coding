package com.linkedin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class PalindromeSubsequence {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sp = new Semaphore(4);
        sp.acquire();
        sp.release();
//        String s = "abcbrta";
        String s = "abqwerba";
        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> res = findPalindromeSubsequences(s, 0, new StringBuilder(), memo);
        for (String r : res) {
            System.out.print(r + " ");
        }
    }

    private static Set<String> findPalindromeSubsequences(String s, int index, StringBuilder curr, Map<String, Set<String>> memo) {
        String key = index + "-" + curr.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        Set<String> res = new HashSet<>();
        if (index == s.length()) {
            if(isPalindrome(curr.toString())) {
                res.add(curr.toString());
            }
            memo.put(key, res);
            return res;
        }
        // include curr char
        curr.append(s.charAt(index));
        res.addAll(findPalindromeSubsequences(s, index+1, curr, memo));
        // backtrack
        curr.deleteCharAt(curr.length()-1);

        // exclude curr char
        res.addAll(findPalindromeSubsequences(s, index+1, curr, memo));
        memo.put(key, res);
        return res;
    }

    private static boolean isPalindrome(String string) {
        int l = 0, r = string.length()-1;
        while (l <= r) {
            if (string.charAt(l) == string.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
