package com.rolex.ctci.ch1_arrays_and_strings.q1_4;

import junit.framework.Assert;

/* 
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or a phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * E.g.
 * Input: Tact Coa (Permutations: 'taco cat', 'atco cta' etc.)
 * Output: True
 */
public class SolutionV2 {

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
	
	// Case when only A-Z and a-z are considered in Palindromic permutation and case-sensitivity doesn't matter.
	private static boolean isPalindromePermutation(String input) {
		
		// Question/Assumption: Can case sensitive character complete a palindrome? Assume Yes.
		// Question/Assumption: Are spaces present? Does their position influence permutation? Assume No.
		// Question/Assumption: Only ASCII characters would be part of the string - only A-Z and a-z will be part of string.
		
		// A palindrome will have even count of all characters, except utmost one character that can have an odd count.
		
		// Maintain an int[] to count no of characters in a-z (or A-Z).
		// Iterate
		// Character.getNumericValue('a')  and Character.getNumericValue('A') return the same value.
		// Determine zero based position by subtracting Character.getNumericValue from Character.getNumericValue('a')
		// Get count of all characters
		
		// Iterate over the array and check whether all characters have even count
		
		// T.C O(N)
		// S.C O(1)
		// N is the length of string
		
		if(input == null || input.trim().equals(""))
			return false;
		
		int[] charCount = new int[26];
		
		for(char c : input.toCharArray()) {
			int numValue = Character.getNumericValue(c);
			
			if(Character.getNumericValue('a') <= numValue && numValue <= Character.getNumericValue('z')) {
				int pos = numValue - Character.getNumericValue('a');
				
				charCount[pos] = charCount[pos] + 1;
			}
		}
		
		boolean oddCountFound = false;
		
		for(int i : charCount) {
			if(i % 2 == 1) {
				if(!oddCountFound)
					oddCountFound = true;
				else
					return false;
			}
		}
		
		return true;
		
	}
}
