package com.practice.leetcode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class AlphabetOrdering {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[] blockSize = new int[N];
			for (int j = 0; j < N; j++) {
				blockSize[j] = sc.nextInt();
			}
			System.out.println("Case #" + i + ": " + finalString(N, blockSize));
		}
		sc.close();
	}

	private static String finalString(int n, int[] blockSize) {
		StringBuilder result = new StringBuilder("A");
		
		char begin = 'B';
		int i;
		for (i = 0; i < n; i+=2) {
			int currSize = blockSize[i];
			int nextSize = 0;
			if (i < n - 1) {
				nextSize = blockSize[i+1];
				char c;
				for (c = begin; c < begin + currSize - 1; c++) {
					result.append(c);
				}
				if (nextSize > currSize) {
					begin = (char) (begin + nextSize - 1);
				} else {
					begin = c;
				}
				result.append(begin);
				char temp = (char) ('A' + nextSize - 1);
				for (c = temp; c >= 'A'; c--) {
					result.append(c);
				}
				begin = 'B';
			} else {
				for (char c = begin; c < begin + blockSize[n-1]; c++) {
					result.append(c);
				}
			}
		}
		return result.toString();
	}
}
