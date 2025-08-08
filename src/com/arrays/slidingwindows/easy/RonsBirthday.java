package com.arrays.slidingwindows.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Two children, Lily and Ron, want to share a chocolate bar. Each of the
 * squares has an integer on it.
 * 
 * Lily decides to share a contiguous segment of the bar selected such that:
 * 
 * The length of the segment matches Ron's birth month, and, The sum of the
 * integers on the squares is equal to his birth day. Determine how many ways
 * she can divide the chocolate.
 */
public class RonsBirthday {

	public static void main(String[] args) {

		int[] arr = { 2, 2, 1, 3, 2 };
		List<Integer> choclateArray = Arrays.stream(arr).boxed().collect(Collectors.toList());
		int birthDay = 4; // max-sum
		int birthMonth = 2; //window

		chocolateDivision(choclateArray, birthDay, birthMonth);

	}

	public static int chocolateDivision(List<Integer> choclateArray, int birthDay, int birthMonth) {
		
		int count = 0;
		
		int maxSum = 0;
		for (int i = 0; i < birthMonth; i++) {
			maxSum += choclateArray.get(i);
		}
		
		if(maxSum == birthDay) {
			count++;
		}
		
		for (int i = birthMonth; i < choclateArray.size(); i++) {
			
			maxSum += choclateArray.get(i) - choclateArray.get(i - birthMonth);
			
			if(maxSum == birthDay) {
				count++;
			}
		}
		
		System.out.println("Possible ways : " + count);

		return count;
	}
}
