package com.linkedin;

import java.util.Stack;

public class MaxStackHelper {
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(6);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());       // Returns 6
        System.out.println(stack.popMax());    // Returns 6
        System.out.println(stack.top());       // Returns 1
        System.out.println(stack.peekMax());   // Returns 5 (the remaining maximum value)
        System.out.println(stack.pop());       // Returns 1
        System.out.println(stack.top());       // Returns 5
    }
}

// 2 stack
class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxValueInStack;

    MaxStack() {
        stack = new Stack<>();
        maxValueInStack = new Stack<>();
    }

    void push(int x) {
        stack.push(x);
        if (maxValueInStack.isEmpty()) {
            maxValueInStack.push(x);
        } else {
            maxValueInStack.push(Math.max(maxValueInStack.peek(), x));
        }
    }

    int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        maxValueInStack.pop();
        return stack.pop();
    }

    int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    int peekMax() {
        if (maxValueInStack.isEmpty()) {
            return -1;
        }
        return maxValueInStack.peek();
    }

    int popMax() {
        Stack<Integer> temp = new Stack<>();
        int max = maxValueInStack.peek();
        while (stack.peek() != max) {
            temp.push(stack.pop());
            maxValueInStack.pop();
        }
        stack.pop();
        maxValueInStack.pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return max;
    }
}
/*
4 4
1 4
5 5
7 7
1 7 ->
temp -> [1]
stack -> [4 1 5 1]
max -> [4 4 5 5]
 */

