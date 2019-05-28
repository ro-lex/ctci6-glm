package com.rolex.ctci.ch1_arrays_and_strings.q1_9;

import junit.framework.Assert;

/* 
 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using 
 * only one call to isSubstring (e.g. "waterbottle" is a rotation of "erbottlewat")
 */
public class SolutionV1 {

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
	
	private static boolean isRotation(String string1, String string2){
		
		// Questions:
		// Can the rotation take place in either direction? Assume yes
		// Both strings need the same characters in the same count to
		// be considered to be a rotation? Assume yes
		// Allowed characters: Assume only A-Z and a-z without any spaces
		// Can String methods be used?
		
		// Find the first occurrence of the first character of string1 in string2
		// offset = above index
		// Check whether the string2 substring from the above character till the 
		// end of string2 is a substring of string1
		// check whether each character in string1 after the above substring
		// is present at i + offset in string2
		
		// T.C. = T.C. of isSubstring + O(y), where string1 = xy
		// S.C. = O(1)
		
		if(string1 == null || string2 == null || "".equals(string1) || "".equals(string2) || string1.length() != string2.length())
			return false;
		
		char string1First = string1.charAt(0);
		
		int offset = string2.indexOf(string1First);
		
		if(isSubstring(string1, string2.substring(offset))){
			int len = string1.length();
			int start = len - offset;
			
			
			for(int i=start; i<len; i++){
				if(string1.charAt(i) != string2.charAt((i + offset) % len))
					return false;
			}
			
			return true;
		}
		
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
