package com.rolex.ctci.ch1_arrays_and_strings.q1_2;

import java.util.Arrays;

import junit.framework.Assert;
/*
 * Check permutation. Given two strings, check whether one is a permutation of the other.
 */

public class SolutionV3 {

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

	// Use sorting of strings
	private static boolean checkPermutation(String string1, String string2){

		// Question/Assumption: if both strings are not of the same length, one cannot be permutation of the other.
		// Question: Case Sensitive? Spaces matter?

		// return false if lengths don't match
		// Sort both strings
		// Return result of .equals() comparison

		// T.C: O(N.log(N))
		// S.C: O(N)
		// N is the length of the string
		
		if(string1 == null || string2 == null || string1.length() != string2.length())
			return false;
		
		char[] str1 = string1.toCharArray();
		char[] str2 = string2.toCharArray();
		
		Arrays.sort(str1);
		Arrays.sort(str2);
		
		return new String(str1).equals(new String(str2));

	}

}
