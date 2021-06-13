package com.practice.interviewbit;

import java.util.Scanner;

public class Primes {
	public static int solve(int[] A, int B) {
        int[] primeFactors = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            primeFactors[i] = primeFactorCount(A[i]);
        }
        int maxPrimeSum = 0;
        for (int i = 0; i < A.length - B + 1; i++) {
            int maxIndex = i;
            int k = i + 1;
            while (k < i + B) {
                if (primeFactors[k] > primeFactors[maxIndex])
                    maxIndex = k;
                k++;
            }
            maxPrimeSum += A[maxIndex];
        }
        return maxPrimeSum;
    }
    
    public static int primeFactorCount(int num) {
        boolean doesThisDivide = false;
        int temp = num;
        int count = 0;
        if (num <= 1)
            return 0;
        while (num % 2 == 0) {
            num /= 2;
            doesThisDivide = true;
        }
        if (doesThisDivide)
            count++;
        
        for (int i = 3; i <= temp / 2; i += 2) {
            doesThisDivide = false;
            while (num % i == 0) {
                num /= i;
                doesThisDivide = true;
            }
            if (doesThisDivide)
                count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) 
			A[i] = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(solve(A, B));
		sc.close();
	}
}
