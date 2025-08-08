package com.arrays.kadensalgorithm.medium;

public class MaximumProductSubarray {

public static void main(String[] args) {
		
		int[] arr = { -2, 3, 2, -7, 1, 3 };

		System.out.println("Maximum Product : " + findMaxProductArray(arr));
		
	}
	
	
	/**
	 * Tracks sum as well as indexes
	 * 
	 * @param nums
	 * @return
	 */
	public static int findMaxProductArray(int[] nums) {

		int maxProduct = nums[0], maxEndingHere = nums[0], minEndingHere = nums[0]; 
        int start = 0, end = 0, tempStart = 0;

		for (int i = 1; i < nums.length; i++) {
			
			int num = nums[i];
			int prevMax = maxEndingHere;
			
			maxEndingHere = Math.max(num, Math.max(num * maxEndingHere, num * minEndingHere));
			minEndingHere = Math.min(num , Math.min(num * prevMax, num * minEndingHere));
			
			
			if(maxEndingHere == num) {
				tempStart = i;
			}
			
			
			if(maxEndingHere > maxProduct) {
				maxProduct = maxEndingHere;
				start = tempStart;
				end = i;
			}

		}

		System.out.println("Indexes of the array : Start : " + start + " & End : " + end);
		
		printArray(nums, start, end);
		
		return maxProduct;
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
