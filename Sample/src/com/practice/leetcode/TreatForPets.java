package com.practice.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TreatForPets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[] petSize = new int[N];
			for (int j = 0; j < N; j++) {
				petSize[j] = sc.nextInt();
			}
			System.out.println("Case #" + i + ": " + minimumNumberOfTreats(N, petSize));
		}
		sc.close();
	}

	private static int minimumNumberOfTreats(int n, int[] petSize) {
		TreeMap<Integer, Integer> petSizeCount = new TreeMap();
		for (int i : petSize) {
			petSizeCount.put(i, petSizeCount.getOrDefault(i,0) + 1);
		}
		int count = 0;
		int lastSize = 1;
		for (Map.Entry element : petSizeCount.entrySet()) {
			int countOfCurrSize = (Integer) element.getValue();
			count += lastSize * countOfCurrSize;
			lastSize++;
		}
		return count;
	}
	
}
