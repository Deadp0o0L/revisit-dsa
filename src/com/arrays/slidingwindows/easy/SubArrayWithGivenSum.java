package com.arrays.slidingwindows.easy;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		
		int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
		
		findSubarray(arr, 10, 9, 4);
		
	}
	
	public static boolean findSubarray(int[] arr, int sum, int n, int m) {
		
		int runningSum = 0;
		for(int i = 0; i < m; i++) {
			runningSum += arr[i];
		}
		
		if (runningSum == sum) {
		    System.out.println("Sum found in the array!");
		    return true;
		}
		
		
		for(int i = m; i < n; i++) {
			runningSum += arr[i] - arr[i - m];
			if(runningSum == sum) {
				System.out.println("Sum found in the array!");
				return true;
			}
		}
		
		System.out.println("No subarray with given sum found.");
		return false;
	}
	
}
