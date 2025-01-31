package com.linkedin;

// https://leetcode.com/problems/robot-bounded-in-circle
public class RobotsBoundedInACircle {
    static int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GG"));
        System.out.println(isRobotBounded("GL"));
    }

    public static boolean isRobotBounded(String instructions) {
        int i = 0, x = 0, y = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                i = (i + 1) % 4;
            } else if (c == 'R') {
                i = (i + 3) % 4;
            } else {
                x += dir[i][0];
                y += dir[i][1];
            }
        }
        return x == 0 && y == 0 || i != 0;
    }
}
