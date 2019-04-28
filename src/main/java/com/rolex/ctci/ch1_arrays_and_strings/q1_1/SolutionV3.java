package com.rolex.ctci.ch1_arrays_and_strings.q1_1;

import junit.framework.Assert;

/*
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use an additional data structure?
 */
public class SolutionV3 {

	public static void main(String[] args) {
		Assert.assertEquals(true, hasUniqueCharacters("asdfgh"));
		Assert.assertEquals(false, hasUniqueCharacters("asdafgh"));
		Assert.assertEquals(false, hasUniqueCharacters("aaa"));
		Assert.assertEquals(true, hasUniqueCharacters("sd23"));
		Assert.assertEquals(false, hasUniqueCharacters("fgf"));
		Assert.assertEquals(false, hasUniqueCharacters("dfs  "));
		Assert.assertEquals(true, hasUniqueCharacters("Gdfg"));
		Assert.assertEquals(false, hasUniqueCharacters(null));
		
		System.out.println("Success");
	}
	

	// Using additional Data structure
	public static boolean hasUniqueCharacters(String input) {
		
		// Question: Is the String ASCII String or Unicode string?
		// Question/Assumption: Case sensitive?
		
		// Use a boolean array to store each character that was encountered before.
		// Iterate over String
		// Check whether array element for the character is 'true'. If yes, return false
 		// Update array element to true. Continue iteration.
		// When iteration is over, return true
		
		// TC: O(min(N,C)) or O(C)
		// SC: O(1) or O(C), if charset size is not fixed
		// N = length of string, C size of charset
		
		if(input == null || input == "" || input.length() > 128)
			return false;
		
		//Assume ASCII
		boolean[] wasFound = new boolean[128];
		
		for(char c : input.toCharArray()) {
			
			if(wasFound[c])
				return false;
			else
				wasFound[c] = true;
		}

		return true;
		
	}

}
