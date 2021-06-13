package com.practice.leetcode;

import java.io.IOException;
import java.util.Scanner;

public class KadaneRepeat {

	public static void main(String args[]) throws IOException {

		// write your code here
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			int[] Arepeated = new int[N * K];
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < K; k++) {
					Arepeated[i + N * k] = A[i];
				}
			}
			System.out.println(maxSum3(N, Arepeated));
		}

	}

	private static int maxSum3(int N, int[] A) {
		int currMax = Integer.MIN_VALUE, prevMax = 0;
		for (int i = 0; i < 3 * N; i++) {
			prevMax += A[i];
			if (currMax < prevMax)
				currMax = prevMax;

			if (prevMax < 0)
				prevMax = 0;
		}
		return currMax;
	}
}
