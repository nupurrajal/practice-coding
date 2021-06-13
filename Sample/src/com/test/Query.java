package com.test;

import java.util.HashSet;
import java.util.Scanner;

public class Query {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> countUNC = new HashSet();
		HashSet<Integer> countUFD = new HashSet();
		HashSet<Integer> finalSet = new HashSet();
		int unccount = 262;
		int ufdcount = 1692;
		while (unccount-- > 0) {
			countUNC.add(sc.nextInt());
		}
		while (ufdcount-- > 0) {
			countUFD.add(sc.nextInt());
		}
		for (Integer curr : countUFD) {
			if (countUNC.contains(curr)) {
				finalSet.add(curr);
			}
		}
		for (Integer i : finalSet)
			System.out.print(i + " ");
		System.out.println(finalSet.size());
	}
}
