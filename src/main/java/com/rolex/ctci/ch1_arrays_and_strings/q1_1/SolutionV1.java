package com.rolex.ctci.ch1_arrays_and_strings.q1_1;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

/*
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use an additional data structure?
 */
public class SolutionV1 {

	public static void main(String[] args) {
		Assert.assertEquals(true, hasUniqueCharacters("asdfgh"));
		Assert.assertEquals(false, hasUniqueCharacters("asdafgh"));
		Assert.assertEquals(false, hasUniqueCharacters("aaa"));
		Assert.assertEquals(true, hasUniqueCharacters("sd23"));
		Assert.assertEquals(false, hasUniqueCharacters("fgf"));
	}
	

	// Using additional Data structure
	public static boolean hasUniqueCharacters(String input) {
		
		// Question: Is the String ASCII String or Unicode string?
		// Question/Assumption: Case sensitive?
		
		// Use a HashSet to store each character that was encountered before.
		// Iterate over String
		// Check whether hash set contains the character. If yes, return false
 		// Add character to hash set. Continue iteration.
		// When iteration is over, return true
		
		// TC: O(N)
		// SC: O(N)
		// N = length of string
		
		Set<Character> characters = new HashSet<>();
		
		char[] chars = input.toCharArray();
		
		for(char character : chars){
			if(characters.contains(character))
				return false;
			else
				characters.add(character);

		}

		return true;
		
	}

}
