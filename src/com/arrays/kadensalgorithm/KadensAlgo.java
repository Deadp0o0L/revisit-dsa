package com.arrays.kadensalgorithm;

/**
 * Problem Statement: Need to find the sub-array with maximum sum
 */
public class KadensAlgo {

	public static void main(String[] args) {

		int[] arr = { -2, 3, 2, -7, 1, 3 };

		System.out.println("Maximum Sum : " + findMaxSum(arr));

		System.out.println("Maximum Sum With Indexes : " + findMaxSumArray(arr));

		System.out.println("Maximum Sum Buggy : " + findMaxSumArrayBuggy(arr));
	}

	/**
	 * Calculates maximum sum
	 * 
	 * @param arr
	 * @return
	 */
	public static int findMaxSum(int[] arr) {

		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int i = 0; i < arr.length; i++) {

			currentSum += arr[i];

			if (currentSum > maxSum) {
				maxSum = currentSum;
			}

			if (currentSum < 0) {
				currentSum = 0;
			}
		}

		return maxSum;
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
		return maxSum;
	}

	/**
	 * Explains why tempStart is required
	 * 
	 * @param arr
	 * @return
	 */
	public static int findMaxSumArrayBuggy(int[] arr) {

		int maxSum = Integer.MIN_VALUE;
		int start = 0, end = 0, currentSum = 0;

		for (int i = 0; i < arr.length; i++) {

			currentSum += arr[i];

			if (currentSum > maxSum) {
				maxSum = currentSum;
				end = i;
			}

			if (currentSum < 0) {
				currentSum = 0;
				start = i + 1;
			}

		}

		System.out.println("Indexes of the array : Start : " + start + " & End : " + end);
		return maxSum;
	}

}
