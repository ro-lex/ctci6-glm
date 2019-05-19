package com.rolex.ctci.ch1_arrays_and_strings.q1_1;

import junit.framework.Assert;

/*
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use an additional data structure?
 */
public class SolutionV4 {

	public static void main(String[] args) {
		Assert.assertEquals(true, hasUniqueCharacters("asdfgh"));
		Assert.assertEquals(false, hasUniqueCharacters("asdafgh"));
		Assert.assertEquals(false, hasUniqueCharacters("aaa"));
		Assert.assertEquals(false, hasUniqueCharacters("fgf"));
		Assert.assertEquals(true, hasUniqueCharacters("dfs"));
		Assert.assertEquals(false, hasUniqueCharacters(null));
		
		System.out.println("Success");
	}
	
	// Solution using Bit Vector
	// This reduces space usage by a factor of 8. (256 bits for ASCII extended character set vs 32 bits for int??)
	// Assume the string only consists of a-z, for simplicity's sake, so that 1 int can be used to store all characters.
	public static boolean hasUniqueCharacters(String input) {
		
		if(input == null || input.length() == 0)
			return false;
		
		int bitVector = 0;
		
		for(int i=0; i<input.length(); i++){
			int currentPosition = input.charAt(i) - 'a';
			
			int currentBit = 1 << currentPosition;
			
			if((bitVector & currentBit) > 0)
				return false;
			
			bitVector = bitVector | currentBit;
		}
		
		return true;
	}
}
