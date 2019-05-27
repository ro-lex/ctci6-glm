package com.rolex.ctci.ch1_arrays_and_strings.q1_6;

import junit.framework.Assert;

/*
 * String Compression: Implement a method to perform basic string compression using the counts of repeated characters. 
 * For example, the string aabcccccaaa would become a2bc5a3. If the "compressed" string would not become smaller than 
 * the original string, your method should return the original string. You can assume the string has only upper case 
 * and lower case letters (a-z) 
 */
public class SolutionV1 {

	public static void main(String[] args) {

		Assert.assertEquals("a2bc5a3", compressString("aabcccccaaa"));
		Assert.assertEquals("a5", compressString("aaaaa"));
		Assert.assertEquals("da5", compressString("daaaaa"));
		Assert.assertEquals("abcde", compressString("abcde"));
		Assert.assertEquals("ab2cde", compressString("abbcde"));
		Assert.assertEquals("a2b2c2", compressString("aabbcc"));
		Assert.assertEquals("a11f2", compressString("aaaaaaaaaaaff"));
		Assert.assertEquals("a11A", compressString("aaaaaaaaaaaA"));
		Assert.assertEquals("", compressString(""));
		Assert.assertEquals(null, compressString(null));
		System.out.println("Success");
	}

	private static String compressString(String input) {

		// Question:
		// What is the character set?
		// What all characters?
		// Case sensitivity matters?
		// Are there spaces present - Assume only A-Z and a-z, ASCII, and no spaces

		// Use a result string
		// Use currentChar="" and currentCharCount=0
		// Iterate over the string
		// If a new character is seen:
		//   if count > 1, set the previous count as the next character in the result
		//   string.
		//   set the current character as the previous character and reset the count to 1.
		//   Append the current character as the next character in the result string
		// Else If the next character is the same:
		//   start counting
		// In cases where the string ends with last character repeating, handle it
		// outside the for loop
		
		// T.C. O(N) - where N is the length of the string
		// S.C. O(1) ?? O(N)??

		StringBuilder result = new StringBuilder();

		if (input == null || input.length() == 0)
			return input;

		char previousChar = 0; // character zero corresponds to ''
		int previousCharCount = 0;

		char[] inputChars = input.toCharArray();

		for (char current : inputChars) {
			if (current != previousChar) {
				if (previousCharCount > 1) {
					result.append(previousCharCount);
				}

				result.append(current);
				previousChar = current;
				previousCharCount = 1;

			} else {
				previousCharCount++;
			}
		}

		if (previousCharCount > 1)
			result.append(previousCharCount);

		return result.toString();
	}

}
