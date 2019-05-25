package com.rolex.ctci.ch1_arrays_and_strings.q1_5;

import junit.framework.Assert;

/*
 * One Away: There are three types of edits that can be performed on strings: insert a character, remove a character,
 * or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 * E.g.
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class SolutionV1 {

	public static void main(String[] args) {
		Assert.assertEquals(true, isOneAway("pale", "ple"));
		Assert.assertEquals(true, isOneAway("pales", "pale"));
		Assert.assertEquals(true, isOneAway("pale", "bale"));
		Assert.assertEquals(false, isOneAway("pale", "bake"));
		Assert.assertEquals(true, isOneAway("pale", "ale"));
		Assert.assertEquals(true, isOneAway("pale", "pal"));
		Assert.assertEquals(false, isOneAway("pales", "pal"));
		Assert.assertEquals(false, isOneAway("pales", null));
		Assert.assertEquals(false, isOneAway(null, "pales"));
		Assert.assertEquals(true, isOneAway("", ""));
		Assert.assertEquals(true, isOneAway("a", ""));
		Assert.assertEquals(false, isOneAway("ab", ""));
		Assert.assertEquals(true, isOneAway("", "a"));
		Assert.assertEquals(false, isOneAway("", "ab"));
		System.out.println("Success");

	}

	private static boolean isOneAway(String input1, String input2) {

		// Remove one character, replace one character, or add one character or no
		// change => true. Else false.

		// Question: would they have spaces, and if yes, does that have any impact:
		// Assume no space.

		// If the two strings differ by more than 1 in length, they are more than one
		// edit away. Return false
		// Have two counters - one for each string
		// Iterate while both strings end is not encountered
		// Compare indexes of each string. If mismatched, increment mismatchCount
		// If both strings are equal in length, increment both counters by one.
		// If strings differ by one, increment the longer string by 1 when encountering
		// a mismatch; both by 1 when match
		// Track mismatch count. Whenever count exceeds 1, return false.

		// T.C O(N), where N is the length of the larger string. 
		// Note that it doesn't matter larger or shorter as the difference is by 1. 
		// For larger differences in length, the code executes in O(1)
		// S.C O(1), is this correct??

		if (input1 == null || input2 == null)
			return false;

		int len1 = input1.length();
		int len2 = input2.length();

		if (Math.abs(len1 - len2) > 1)
			return false;

		boolean equalLength = (len1 == len2) ? true : false;

		int i = 0, j = 0;
		boolean mismatch = false;

		while (i < len1 && j < len2) {
			if (input1.charAt(i) == input2.charAt(j)) {
				i++;
				j++;
				continue;
			} else {
				if (mismatch)
					return false;
				else
					mismatch = true;

				if (equalLength) {
					i++;
					j++;
				} else {
					if (len1 > len2)
						i++;
					else
						j++;
				}
			}
		}

		return true;
	}

}
