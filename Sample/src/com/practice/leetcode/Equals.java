package com.practice.leetcode;

import java.io.IOException;
import java.util.Scanner;

public class Equals {

	public static void main(String args[]) throws IOException {
	    
	    //write your code here
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    long[] A = new long[N];
	    long min = Long.MAX_VALUE;
	    for (int i = 0; i < N; i++) {
	      A[i] = sc.nextLong();
	      min = Math.min(min, A[i]);
	    }
	    System.out.println(mkeq(N, A, min));
	  }
	  
	  private static String mkeq(int N, long[] A, long min) {
	    long lcmValue = lcm_of_array_elements(A);
	    for (int i = 0; i < N; i++) {
	      long currValue = A[i] * 2 * 3;
	      if (lcmValue % currValue != 0)
	    	  return "NO";
	    }
	    return "YES";
	  }
	  
	  public static long lcm_of_array_elements(long[] element_array)
	    {
	        long lcm_of_array_elements = 1;
	        int divisor = 2;
	         
	        while (true) {
	            int counter = 0;
	            boolean divisible = false;
	             
	            for (int i = 0; i < element_array.length; i++) {
	                if (element_array[i] == 0) {
	                    return 0;
	                }
	                else if (element_array[i] < 0) {
	                    element_array[i] = element_array[i] * (-1);
	                }
	                if (element_array[i] == 1) {
	                    counter++;
	                }
	                if (element_array[i] % divisor == 0) {
	                    divisible = true;
	                    element_array[i] = element_array[i] / divisor;
	                }
	            }
	 
	          
	            if (divisible) {
	                lcm_of_array_elements = lcm_of_array_elements * divisor;
	            }
	            else {
	                divisor++;
	            }
	            if (counter == element_array.length) {
	                return lcm_of_array_elements;
	            }
	        }
	    }
}
