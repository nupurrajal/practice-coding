package com.linkedin;

import java.util.HashSet;
import java.util.Set;

public class CountPalindromicSubsequences {

    static int MOD = 1000000007;

    public static void main(String[] args) {
        String s = "bccb";
        System.out.println(computeCountOfPalindromicSubsequencesRecursion(s));
        System.out.println(getCountOfPalindromicSubsequencesDP(s));
    }

    private static int getCountOfPalindromicSubsequencesDP(String s) {
        int n = s.length();
        // dp[i][j] = count of palindromic subsequence in string(i:j)
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // we need to consider only the length 2 substrings, 1 is palindrome
        for (int len = 2; len <= n; len++) {
            // 'i' is the index where a substring of length len would start
            for (int i = 0; i <= n-len; i++) {
                // 'j' will be the last index of the substring of length len and starting with index i
                int j = len + i - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    // 2 possibilities - 1) palindrome by adding s[i] & s[j] in s[i+1.j-1]
                    // 2) palindrome without adding s[i] & s[j] in s[i+1..j-1]
                    // 1 because s[i] itself will be a palindrome
                    dp[i][j] = 2 * dp[i+1][j-1];
                    int left = i + 1, right = j - 1;
                    // Avoid counting the palindromes twice
                    while (left <= right && s.charAt(left) != s.charAt(i)) {
                        left++;
                    }
                    while (left <= right && s.charAt(right) != s.charAt(i)) {
                        right--;
                    }
                    // Adjust count for duplicates (potential over counting)
                    if (left == right) {
                        dp[i][j] += 1; // There's one duplicate subsequence formed by s[i] and s[j] in the middle
                    } else if (left > right) {
                        dp[i][j] += 2; // We've counted the same subsequences twice
                    } else {
                        dp[i][j] -= dp[left+1][right-1];
                    }
                } else {
                    // count palindromes in substring with s[i] and without s[j]
                    // i+1,j -> counts palindromes starting after 'i'
                    // i,j-1 -> counts palindromes ending before j
                    // i+1,j-1 -> counts palindromes that we’ve counted twice (once in the previous two counts), so we subtract it to avoid duplicates.
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + MOD : dp[i][j] % MOD;
            }
        }
        return dp[0][n-1];
    }

    private static int computeCountOfPalindromicSubsequencesRecursion(String s) {
        Set<String> uniquePalindromes = new HashSet<>();
        computeCountOfPalindromicSubsequencesRecursion(s, 0, new StringBuilder(), uniquePalindromes);
        return uniquePalindromes.size();
    }

    private static void computeCountOfPalindromicSubsequencesRecursion(String s, int idx, StringBuilder curr, Set<String> uniquePalindromes) {
        if (idx == s.length()) {
            String res = curr.toString();
            if (!res.isEmpty() && isPalindrome(res)) {
                uniquePalindromes.add(res);
            }
            return;
        }
        curr.append(s.charAt(idx));
        computeCountOfPalindromicSubsequencesRecursion(s, idx+1, curr, uniquePalindromes);
        curr.deleteCharAt(curr.length()-1);

        computeCountOfPalindromicSubsequencesRecursion(s, idx+1, curr, uniquePalindromes);
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
