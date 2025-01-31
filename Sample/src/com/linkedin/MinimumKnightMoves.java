package com.linkedin;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
find the minimum number of moves a knight on a chessboard needs to go from the origin (0, 0) to a target square (x, y)
 */
public class MinimumKnightMoves {
    static int[][] directions = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    public static void main(String[] args) {
        int x = 500, y = 500;
        LocalDateTime start = LocalDateTime.now();
        System.out.println(getMinKnightMoves(x, y));
        LocalDateTime end = LocalDateTime.now();
        long diffInMillis = ChronoUnit.MILLIS.between(start, end);
        System.out.println("Time taken: " + diffInMillis + " ms");
    }

    private static int getMinKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new int[]{0,0,0}); // x,y,moves
        visited.add("0,0");
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1], cm = curr[2];
            for (int[] d : directions) {
                int dx = cx + d[0], dy = cy + d[1];
                if (x == dx && y == dy) {
                    return cm;
                }
                if (!visited.contains(dx+","+dy)) {
//                if (!visited.contains(dx+","+dy) && dx >= -2 && dy >= -2) {
                    queue.offer(new int[]{dx, dy, cm+1});
                    visited.add(dx+","+dy);
                }
            }
        }
        return -1;
    }
}
