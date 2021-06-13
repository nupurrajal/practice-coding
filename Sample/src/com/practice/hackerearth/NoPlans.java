package com.practice.hackerearth;

import java.util.*;

public class NoPlans {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<Set<Integer>> busyDays = new ArrayList();
        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            Set<Integer> set = new HashSet();
            for (int k = 0; k < m; k++) {
                int n1 = s.nextInt();
                int n2 = s.nextInt();
                for (int j = n1; j <= n2; j++)
                    set.add(j);
            }
            busyDays.add(set);
        }
        System.out.println(noPlanDay(busyDays));
	}
	
	static int noPlanDay(List<Set<Integer>> busyDays) {
        Integer val = 1;
        while (val < 1000000) {
            if (!busyDays.get(0).contains(val) && !busyDays.get(1).contains(val) && !busyDays.get(2).contains(val) && !busyDays.get(3).contains(val)) 
                return val;
            val++;
        }
        return -1;
    }
}
