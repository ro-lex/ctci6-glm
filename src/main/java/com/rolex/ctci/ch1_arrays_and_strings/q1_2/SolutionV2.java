package com.rolex.ctci.ch1_arrays_and_strings.q1_2;

import junit.framework.Assert;
/*
 * Check permutation. Given two strings, check whether one is a permutation of the other.
 */

public class SolutionV2 {

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

	// Using character array for entire Charset
	private static boolean checkPermutation(String string1, String string2){

		// Question/Assumption: if both strings are not of the same length, one cannot be permutation of the other.
		// Question/Assumption: Character set. Assumed to be ASCII
		// Question: Case Sensitive? Spaces matter?

		// return false if lengths don't match
		// Maintain a character array to track the count of each character
		// Iterate first string and store the counts in the character array
		// Iterate second string and check whether present in the array. 
		// Decrement from array if match found
		// Return false if match not found
		// Return true when iteration ends

		// T.C: O(N)
		// S.C: O(C) or O(1)
		// N is the length of the string, C is the size of charset
		
		if(string1 == null || string2 == null || string1.length() != string2.length())
			return false;
		
		int[] characters = new int[128];
		
		for(int i=0; i< string1.length(); i++) {
			int character1 = string1.charAt(i);
			int count = characters[character1];
			characters[character1] = ++count;
		}
		
		for(int j=0; j<string2.length(); j++) {
			int character2 = string2.charAt(j);
			int count2 = characters[character2];
			if(count2 == 0)
				return false;
			else
				characters[character2] = --count2;
		}
		
		return true;

	}

}
