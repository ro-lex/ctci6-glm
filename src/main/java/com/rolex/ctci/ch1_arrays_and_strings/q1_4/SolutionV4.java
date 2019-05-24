package com.rolex.ctci.ch1_arrays_and_strings.q1_4;

import junit.framework.Assert;

/* 
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or a phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words. sYou can ignore casing and non-letter characters.
 * E.g.
 * Input: Tact Coa (Permutations: 'taco cat', 'atco cta' etc.)
 * Output: True
 */
public class SolutionV4 {

	public static void main(String[] args) {
		
		Assert.assertEquals(true, isPalindromePermutation("tact coa"));
		Assert.assertEquals(true, isPalindromePermutation("able was i ere i saw elba"));
		Assert.assertEquals(false, isPalindromePermutation("able was i ere i saw ibiza"));
		Assert.assertEquals(false, isPalindromePermutation(null));
		Assert.assertEquals(false, isPalindromePermutation("   "));
		Assert.assertEquals(true, isPalindromePermutation(" tact coa  "));
		Assert.assertEquals(true, isPalindromePermutation("Tact coa"));
		Assert.assertEquals(true, isPalindromePermutation("LiriL"));
		Assert.assertEquals(true, isPalindromePermutation("Liril"));
		Assert.assertEquals(true, isPalindromePermutation("LirriL"));
		Assert.assertEquals(false, isPalindromePermutation("LirrriiL"));

		System.out.println("Success");

	}
	
	// Use a bit vector to track whether a letter has even or odd count
	private static boolean isPalindromePermutation(String input){
		
		// Assume only letters are part of the string
		// Use a 32 bit integer to keep track of count of letters
		// Iterate the characters
		// Use signed left shift on '1' with the present character 0 based position, to mark the present character
		// The result is of the pattern ..0001000..
		// An XOR with the above pattern - the positions against the 1 gets toggled, and positions against 0 remain as-is.
		// Toggle the existing count
		// Once done, validate that utmost one 1 is present.
		// Subtract 1 from the bit vector. Resultant value has 1's not overlapping with the operated value, if the initial
		// value was all 0's or only 1's
		// i.e. 00000000 - 1 = 11111111. AND for both = 0
		//      00010000 - 1 = 00001111. AND for both = 0
		
		if(input == null || input.length() <= 0 || input.trim().length() == 0)
			return false;
		
		int bitVector = 0;
		char[] chars = input.toCharArray();

		for(int i=0; i<chars.length; i++){
			int j = chars[i];

			if(Character.getNumericValue(j) < Character.getNumericValue('a') || 
					Character.getNumericValue(j) > Character.getNumericValue('z')){
				continue;
			}

			int value = Character.getNumericValue(j) - Character.getNumericValue('a');
			
			int currentCharacterBit = 1 << value;
			
			bitVector = bitVector ^ currentCharacterBit;
		}
		
		
		int bitVectorLessOne = bitVector - 1;

		if((bitVector & bitVectorLessOne) > 0)
			return false;
		else
			return true;
	
	}

}
