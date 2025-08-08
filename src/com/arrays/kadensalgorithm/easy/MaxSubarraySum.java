package com.arrays.kadensalgorithm.easy;

public class MaxSubarraySum {

	
	public static void main(String[] args) {
		
		int[] arr = { -2, 3, 2, -7, 1, 3 };

		System.out.println("Maximum Sum : " + findMaxSumArray(arr));
		
	}
	
	
	/**
	 * Tracks sum as well as indexes
	 * 
	 * @param arr
	 * @return
	 */
	public static int findMaxSumArray(int[] arr) {

		int maxSum = Integer.MIN_VALUE;
		int start = 0, end = 0, currentSum = 0, tempStart = 0;

		for (int i = 0; i < arr.length; i++) {

			currentSum += arr[i];

			if (currentSum > maxSum) {
				maxSum = currentSum;
				end = i;
				start = tempStart;
			}

			if (currentSum < 0) {
				currentSum = 0;
				tempStart = i + 1;
			}

		}

		System.out.println("Indexes of the array : Start : " + start + " & End : " + end);
		
		printArray(arr, start, end);
		
		return maxSum;
	}
	
	
	/**
	 * Print Array
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void printArray(int[] arr, int start, int end) {
		
		if (arr == null || start < 0 || end >= arr.length || start > end) {
			System.out.println("Invalid input");
			return;
		}

		for (int i = start; i <= end; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}
	
}
