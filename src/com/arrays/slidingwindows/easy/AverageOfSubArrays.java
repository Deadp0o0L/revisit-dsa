package com.arrays.slidingwindows.easy;

public class AverageOfSubArrays {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };

		printArray(findAverage(arr, 9, 5));

	}

	public static double[] findAverage(int[] arr, int n, int k) {

		double[] avgArr = new double[n - k + 1];

		int runningSum = 0;
		for (int i = 0; i < k; i++) {
			runningSum += arr[i];
		}

		avgArr[0] = parseNum((double) runningSum / k);

		for (int i = k; i < n; i++) {

			runningSum += arr[i] - arr[i - k];
			avgArr[i - k + 1] = parseNum((double) runningSum / k);			
		}

		return avgArr;
	}

	public static void printArray(double[] arr) {

		for (double i : arr) {
			System.out.print(i + " ");
		}
	}
	
	public static double parseNum(double num) {
		
		return Math.round(num * 10.0) / 10.0;
	}
}
