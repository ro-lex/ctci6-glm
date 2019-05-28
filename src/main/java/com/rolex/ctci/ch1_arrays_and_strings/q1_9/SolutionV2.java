package com.rolex.ctci.ch1_arrays_and_strings.q1_9;

import junit.framework.Assert;

/* 
 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using 
 * only one call to isSubstring (e.g. "waterbottle" is a rotation of "erbottlewat")
 */
public class SolutionV2 {

	public static void main(String[] args) {
		
		boolean result = isRotation("waterbottle", "erbottlewat");
		Assert.assertEquals(true, result);
		
		result = isRotation("waterbottle", "tlewaterbot");
		Assert.assertEquals(true, result);
		
		result = isRotation("waterbottle", "erbottlewa");
		Assert.assertEquals(false, result);
		
		result = isRotation("waterbottle", "bottlewa");
		Assert.assertEquals(false, result);

		result = isRotation("waterbottle", "erbottlewta");
		Assert.assertEquals(false, result);
		
		result = isRotation("", "");
		Assert.assertEquals(false, result);
		
		result = isRotation("abx", null);
		Assert.assertEquals(false, result);
		
		System.out.println("Success");
	}
	
	// CTCI solution
	private static boolean isRotation(String string1, String string2){
		
		// If a string is of the format xy, the rotated string will be yx
		// There yx is a substring of xyxy
		
		// T.C. = T.C of isSubstring.
		// If T.C is O(A+B), where A and B are lengths of string1 and string2,
		// T.C. is O(N)
		// S.C. O(A)
		
		if(string1 == null || string2 == null || "".equals(string1) || "".equals(string2) || string1.length() != string2.length())
			return false;
		
		String replicate = string1 + string1;
		
		if(isSubstring(replicate, string2))
			return true;
		else
			return false;
	}
	
	// Stub implementation
	private static boolean isSubstring(String string1, String string2){
		if(string1.indexOf(string2) > -1)
			return true;
		else
			return false;
	}

}
