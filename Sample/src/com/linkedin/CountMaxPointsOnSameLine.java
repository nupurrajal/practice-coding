package com.linkedin;

import java.util.HashMap;
import java.util.Map;

public class CountMaxPointsOnSameLine {
    public static void main(String[] args) {
        int[][] points = { { -1, 1 }, { 0, 0 }, { 1, 1 },
                { 2, 2 },  { 3, 3 }, { 3, 4 } };
        System.out.println(maxPointsOnSameLine(points));
    }

    private static int maxPointsOnSameLine(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }
        int result = 1;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap();
            int[] p1 = points[i];
            for (int j = i+1; j < points.length; j++) {
                int[] p2 = points[j];
                String slope = "VERTICAL";
                if (p2[0] != p1[0]) {
                    int x = p2[0] - p1[0], y = p2[1] - p1[1];
                    int gcd = gcd(x, y);
                    x /= gcd;
                    y /= gcd;
                    if (x < 0) {
                        x = -x;
                        y = -y;
                    }
                    slope = y + "/" + x;
                }
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                result = Math.max(result, slopeMap.get(slope) + 1);
            }
        }
        return result;
    }

    static int gcd(int p, int q) {
        return q == 0 ? p : gcd(q, p%q);
    }
}
