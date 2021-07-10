package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ShrinkArr {

    public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
        List<String> result = new ArrayList<>();
        Stack<String> chars = new Stack();
        Stack<Integer> count = new Stack();
        if (burstLength <= 1) {
            return new ArrayList<String>();
        }
        System.out.println(burstLength);
        System.out.println(inputArray);
        for (String s : inputArray) {
            if (!chars.isEmpty() && !count.isEmpty() && chars.peek().equals(s) && count.peek() >= burstLength-1) {
                while(!chars.isEmpty() && chars.peek().equals(s)){
                    chars.pop();
                }
                count.pop();
            } else {
                int currCount = 1;
                if (!chars.isEmpty() && chars.peek().equals(s)) {
                    currCount += count.pop();
                }
                chars.push(s);
                count.push(currCount);
            }
        }
        while (!chars.isEmpty()) {
            result.add(chars.pop());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int bl = 3;
        String s = "a b c d e e e e e d d c b f g f h h h t";
        List<String> input = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                input.add(String.valueOf(c));
            }
        }
        System.out.println(getShrunkArray(input, bl));
    }
}
