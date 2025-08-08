package com.arrays.slidingwindows.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A driver is driving on the freeway. The check engine light of his vehicle is
 * on, and the driver wants to get service immediately. Luckily, a service lane
 * runs parallel to the highway. It varies in width along its length.
 */
public class ServiceLane {

	public static void main(String[] args) {
		
		int n = 4;
		
		int[] widthArr = {2,3,2,1};
		
		int[][] casesArr = {{1,2}, {2,4}};
		
		List<List<Integer>> cases = Arrays.stream(casesArr)
			    .map(row -> Arrays.stream(row)
	                      .boxed()
	                      .collect(Collectors.toList()))
			    		  .collect(Collectors.toList());
		
		List<Integer> width = Arrays.stream(widthArr)
									.boxed()
									.collect(Collectors.toList());
		
		
		serviceLane(n, width ,cases);
		
		
	}

	public static List<Integer> serviceLane(int n, List< Integer> width, List<List<Integer>> cases) {

		List<Integer> list = new ArrayList();
		
		for (int i = 0; i < cases.size(); i++) {
			
			
		}
		
	}

}
