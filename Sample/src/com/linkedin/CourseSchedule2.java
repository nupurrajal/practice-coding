package com.linkedin;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int n = 4;
        int[] result = getSequenceOfCourses(prerequisites, n);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] getSequenceOfCourses(int[][] prerequisites, int n) {
        int[] result = new int[n];
        int[] inorder = new int[n];
        for (int[] p : prerequisites) {
            inorder[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inorder[i] == 0) {
                queue.add(i);
            }
        }
        int k = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[k++] = course;
            for (int[] p : prerequisites) {
                if (p[1] == course) {
                    inorder[p[0]]--;
                    if (inorder[p[0]] == 0) {
                        queue.add(p[0]);
                    }
                }
            }
        }
        if (k != n) {
            return new int[0];
        }
        return result;
    }
}
