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
public class SolutionV1 {

	public static void main(String[] args) {
		
		Assert.assertEquals(true, isPalindromePermutation("tact coa"));
		Assert.assertEquals(true, isPalindromePermutation("able was i ere i saw elba"));
		Assert.assertEquals(false, isPalindromePermutation("able was i ere i saw ibiza"));
		Assert.assertEquals(false, isPalindromePermutation(null));
		Assert.assertEquals(false, isPalindromePermutation("   "));
		Assert.assertEquals(true, isPalindromePermutation(" tact coa  "));
		
		System.out.println("Success");

	}
	
	private static boolean isPalindromePermutation(String input) {
		
		// Question/Assumption: Can case sensitive character complete a palindrome? Assume No.
		// Question/Assumption: Are spaces present? Does their position influence permutation? Assume No.
		// Question/Assumption: Only ASCII characters would be part of the string.
		
		// A palindrome will have even count of all characters, except utmost one character that can have an odd count.
		
		// Maintain an int[] to count no of characters. Iterate and get count
		
		// Iterate over the string and check whether all strings have even count
		// Exception is space character
		// Exception is atmost one character that can have odd count
		
		// T.C O(N)
		// S.C O(1)
		// N is the length of string
		
		if(input == null || input.trim().equals(""))
			return false;
		
		int[] charCount = new int[128];
		char oddCountChar = 0;
		
		for(char character : input.toCharArray()) {
			charCount[character] = charCount[character] + 1;
		}
		
		for(char chr : input.toCharArray()) {
			if(chr == 32)
				continue;
			
			if(charCount[chr] % 2 == 0)
				continue;
			else {
				if(oddCountChar != 0 && chr != oddCountChar)
					return false;
				if(oddCountChar == 0)
					oddCountChar = chr;
			}
		}
		
		return true;
		
	}
}
