package com.linkedin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = new String[]{"leet", "code"};
        Set<String> words = new HashSet<>(List.of(wordDict));
        System.out.println(checkWordDictBacktracking(s, words, 0));
        System.out.println(checkWordDictTopDownDP(s, words));
    }

    private static boolean checkWordDictTopDownDP(String s, Set<String> words) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        for (int i = s.length()-1; i >= 0; i--) {
            for (String word : words) {
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }


    private static boolean checkWordDictBacktracking(String s, Set<String> words, int nextPos) {
        if (nextPos == s.length()) {
            return true;
        }
        for (int i = nextPos; i < s.length(); i++) {
            String curr = s.substring(nextPos, i+1);
            if (words.contains(curr)) {
                if (checkWordDictBacktracking(s, words, i+1)) {
                    return true;
                }
            }
        }
        return false;
    }

}
