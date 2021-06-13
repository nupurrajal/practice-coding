package com.practice.leetcode;

import java.util.Scanner;

class BinaryTree {
	BinaryTree left, right;
	int value;
	
	public BinaryTree(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class GameOfPieces {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			String pieces = sc.next();
			System.out.println("Case #" + i + ": " + winnerAndPoints(pieces));
		}
		sc.close();
	}

	private static String winnerAndPoints(String pieces) {
		BinaryTree root = new BinaryTree(-1);
		boolean chanceI = true;
		long test= Long.MAX_VALUE;
		long test1 = Math.min(test, 0);
		int i = 0;
		int left = 0, right = pieces.length() - 1;
		while (i < pieces.length()) {
			if (chanceI) {
				if (pieces.charAt(left) != 'I' && pieces.charAt(right) != 'I') {
					return "O " + String.valueOf(right - left + 2);
				}
				if (pieces.charAt(left) == 'I') {
					root.left = new BinaryTree(left);
				}
				if (pieces.charAt(right) == 'I') {
					root.right = new BinaryTree(right);
				}
				chanceI = false;
			} else {
				if (pieces.charAt(left) != 'O' && pieces.charAt(right) != 'O') {
					return "I " + String.valueOf(right - left + 2);
				}
				if (pieces.charAt(left) == 'O') {
					root.left = new BinaryTree(left);
				}
				if (pieces.charAt(right) == 'O') {
					root.right = new BinaryTree(right);
				}
				chanceI = true;
			}
			i++;
		}
		
		return "";
	}
}
