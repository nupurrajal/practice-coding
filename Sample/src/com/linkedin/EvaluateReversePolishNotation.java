package com.linkedin;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evaluateRPN(tokens));
    }

    private static int evaluateRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        for (String t : tokens) {
            if (ops.contains(t)) {
                Integer b = Integer.parseInt(stack.pop());
                Integer a = Integer.parseInt(stack.pop());
                int val = 0;
                switch (t) {
                    case "+" : val = a + b; break;
                    case "-" : val = a - b; break;
                    case "*" : val = a * b; break;
                    case "/" : val = a / b; break;
                };
                stack.push(String.valueOf(val));
            } else {
                stack.push(t);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
