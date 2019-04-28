package com.rolex.ctci.ch1_arrays_and_strings.q1_2;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
/*
 * Check permutation. Given two strings, check whether one is a permutation of the other.
 */

public class SolutionV1 {

	public static void main(String[] args) {

		Assert.assertEquals(true, checkPermutation("abs","sab"));
		Assert.assertEquals(false, checkPermutation("abs","saa"));
		Assert.assertEquals(true, checkPermutation("112","211"));
		Assert.assertEquals(true, checkPermutation("111","111"));
		Assert.assertEquals(false, checkPermutation("abs","abs1"));
		Assert.assertEquals(false, checkPermutation(null,"abs1"));
		Assert.assertEquals(false, checkPermutation("asb1 ","abs1"));
		Assert.assertEquals(true, checkPermutation("asb1 ","abs 1"));
		Assert.assertEquals(false, checkPermutation("dog ","Dog"));
		
		System.out.println("Success");

	}

	// Using HashMap to store character-count mapping
	private static boolean checkPermutation(String string1, String string2){

		// Question/Assumption: if both strings are not of the same length, one cannot be permutation of the other.
		// Question: Case Sensitive? Spaces matter?

		// return false if lengths don't match
		// Maintain a hash map for the count of each character in first string
		// Iterate first string and store the counts
		// Iterate second string and check whether present in hash map. 
		// Decrement/remove from hash map if match found
		// Return false if match not found
		// Return true when iteration ends

		// T.C: O(N)
		// S.C: O(N)
		// N is the length of the string

		if(string1 == null || string2 == null || string1.length() != string2.length())
			return false;

		Map<Character, Integer> charMap = new HashMap<>();

		for(int i=0; i< string1.length(); i++){

			Character character1 = string1.charAt(i);

			charMap.put(character1, charMap.getOrDefault(character1, 0) + 1);
		}
		
		for(int j=0; j<string2.length(); j++){

			Character character2 = string2.charAt(j);

			int count = charMap.getOrDefault(character2, 0);
			
			if(count == 0)
				return false;
			else
				charMap.put(character2, --count);
			
		}

		return true;

	}

}
