package com.linkedin;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {

    public static void main(String[] args) {
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");
        int[] res = exclusiveTime(n, logs);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack();
        int[] res = new int[n];
        int prevTime = 0;
        for (String s : logs) {
            String[] arr = s.split("\\:");
            int id = Integer.valueOf(arr[0]);
            int time = Integer.valueOf(arr[2]);
            String state = arr[1];
            if (state.equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] += time - prevTime;
                }
                stack.push(new int[]{id, time});
                prevTime = time;
            } else {
                int[] curr = stack.pop();
                res[curr[0]] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return res;
    }
}
