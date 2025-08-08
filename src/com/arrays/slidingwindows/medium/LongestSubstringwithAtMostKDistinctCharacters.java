package com.arrays.slidingwindows.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringwithAtMostKDistinctCharacters {
	
	public static void main(String[] args) {
		
		longestSubstringNew("abccabefa", 5);
	}
	
	
	public static String longestSubstring(String s, int k) {
		
		if(s == null || s.isEmpty() || s.length() < k) return "";
		
		int start = 0;
		
		Set<Character> seen = new HashSet<>();
		
		for (int end = 0; end < s.length(); end++) {
			
			char currentChar = s.charAt(end);
			
			while(seen.contains(currentChar)) {
				seen.remove(s.charAt(start));
				start++;
			}
			
			seen.add(currentChar);
			

			System.out.println("Seen : " + seen);
			
			if(seen.size() == k) {
				System.out.println("Substring found : " + s.substring(start, end + 1));
				return s.substring(start, end + 1);
			}
			
		}
		
		
		System.out.println("Substring not found for length k!");
		
		return "";
	}
	
	public static String longestSubstringNew(String s, int k) {
		if (s == null || s.isEmpty() || k == 0)
			return "";

		Map<Character, Integer> countMap = new HashMap<>();
		int start = 0, maxLen = 0, maxStart = 0;

		for (int end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);

			while (countMap.size() > k) {
				char left = s.charAt(start);
				countMap.put(left, countMap.get(left) - 1);
				if (countMap.get(left) == 0) {
					countMap.remove(left);
				}
				start++;
			}

			if (end - start + 1 > maxLen) {
				maxLen = end - start + 1;
				maxStart = start;
			}
		}

		return s.substring(maxStart, maxStart + maxLen);
	}


}
