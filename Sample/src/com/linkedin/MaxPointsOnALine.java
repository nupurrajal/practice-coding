package com.linkedin;

import java.util.HashMap;
import java.util.Map;

import static com.linkedin.CountMaxPointsOnSameLine.gcd;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        int[][] points = {{1,1}, {2,2}, {3,3}};
        System.out.println(getMaxPointsOnLine(points));
    }

    private static int getMaxPointsOnLine(int[][] points) {
        int result = 1;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            Map<String, Integer> slopeMap = new HashMap<>();
            for (int j = i+1; j < points.length; j++) {
                String slope = "VERTICAL";
                int[] p2 = points[j];
                // check for vertical
                if (p1[0] != p2[0]) {
                    int x = p2[0] - p1[0];
                    int y = p2[1] - p1[1];
                    int gcd = gcd(x,y);
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
}
