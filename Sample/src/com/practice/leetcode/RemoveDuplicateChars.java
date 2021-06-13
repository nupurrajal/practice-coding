package com.practice.leetcode;

import java.util.Scanner;
import java.util.Stack;

public class RemoveDuplicateChars {

	public static String removeDuplicates(String s, int k) {
        if (s.length() < k)
            return s;
        StringBuilder result = new StringBuilder();
       
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));
        int i = 1;
        int count = 1;
        char prev = s.charAt(0);
        while (i < s.length()) {
            char curr = s.charAt(i);
            if (curr == prev)
                count++;
            if (count == k) {
                int ktemp = k-1;
                while (ktemp-- > 0) {
                    stack.pop();
                }
                count = 1;
                
            } else {
                prev = curr;
                stack.push(curr);
            }
            i++;
        }
        while (!stack.empty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		String s = sc.next();
		System.out.println(removeDuplicates(s, k));
		sc.close();
	}
}
