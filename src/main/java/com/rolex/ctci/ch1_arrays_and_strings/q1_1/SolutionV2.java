package com.rolex.ctci.ch1_arrays_and_strings.q1_1;

import junit.framework.Assert;

/*
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use an additional data structure?
 */
public class SolutionV2 {

	public static void main(String[] args) {
		Assert.assertEquals(true, hasUniqueCharacters("asdfgh"));
		Assert.assertEquals(false, hasUniqueCharacters("asdafgh"));
		Assert.assertEquals(false, hasUniqueCharacters("aaa"));
		Assert.assertEquals(true, hasUniqueCharacters("sd23"));
		Assert.assertEquals(false, hasUniqueCharacters("fgf"));
	}

	// Note: this is not the proper solution without additional D.S. Bit Vector?? Sorting ??
	private static boolean hasUniqueCharacters(String input){

		// Create a StringBuilder from the String
		// While string length is greater than 1
		// get first character
		// calculate length of string
		// replace all occurrences of first character
		// compute length of new string
		// if length difference is greater than 1, return false
		// After iteration completes, return true

		// TC: O(N)
		// SC: O(N)
		// N is length of the string

		StringBuilder strBuilder = new StringBuilder(input);

		while(strBuilder.length() > 1){

			Character first = strBuilder.charAt(0);

			if(strBuilder.indexOf(first.toString()) != strBuilder.lastIndexOf(first.toString()))
				return false;

			strBuilder.deleteCharAt(0);

		}

		return true;
	}

}
