package com.arrays.slidingwindows;

/**
 * @see Sliding Windows Approach : Reduce the complexity by reusing the result
 *      of previous computations
 * 
 *      n = size of array m = window size
 *      
 *      
 *      number of window : n - k + 1
 */
public class FindMaxSum {

	public static void main(String[] args) {

		int[] arr = { 20, 10, -10, 15, 5 };

		System.out.println(findMaxSumNaive(arr, 5, 3));

		System.out.println(findMaxSum(arr, 5, 3));
		
		System.out.println(findMaxSumTwoPointer(arr, 5, 3));

	}

	/**
	 * @implNote Naive Approach
	 */
	public static int findMaxSumNaive(int arr[], int n, int m) {

		int maxResult = Integer.MIN_VALUE;

		for (int i = 0; i <= n - m; i++) {

			int runningSum = 0;

			for (int j = i; j < i + m; j++) {
				runningSum += arr[j];
			}

			maxResult = Math.max(maxResult, runningSum);
		}
		return maxResult;
	}

	/**
	 * @implNote Optimal Approach
	 * @see Calulate the size of window, then add the next value and substract the first (next - window)
	 */
	public static int findMaxSum(int arr[], int n, int m) {

		// Calculate the sum of first m elements
		int maxResult = 0;
		for (int i = 0; i < m; i++) {
			maxResult += arr[i];
		}

		// Calculate the sum of remaining window
		int runningSum = maxResult;
		for (int j = m; j < n; j++) {
			runningSum += arr[j] - arr[j - m];
			maxResult = Math.max(maxResult, runningSum);
		}

		return maxResult;
	}
	
	
	/**
	 * @implNote Optimal Approach
	 */
	public static int findMaxSumTwoPointer(int arr[], int n, int m) {

		// Calculate the sum of first m elements
		int maxResult = 0;
		int left = 0, right = m - 1;
		
		for (int i = 0; i <= right; i++) {
			maxResult += arr[i];
		}
		
		System.out.println("Max Result of Iteration 0 : " + maxResult);
		
		int sum = maxResult;
		while(right < n - 1) {
			
			sum -= arr[left];
			left++;
			right++;
			sum += arr[right];
			
			maxResult = Math.max(maxResult, sum);
			System.out.println("Max Result of Iteration " +  left + " : " + maxResult);
		}

		return maxResult;
	}

}
