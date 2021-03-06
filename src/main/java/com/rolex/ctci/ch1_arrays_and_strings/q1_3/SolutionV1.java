package com.rolex.ctci.ch1_arrays_and_strings.q1_3;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

/*
 * URLify: Write a method to replace all spaces in a string with '%20'. 
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string. (Note: if implementing in Java, use a character array 
 * so that you can perform this operation in place.)
 * E.g. 
 * Input: "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
public class SolutionV1 {

	public static void main(String[] args) {
		String str = "Mr John Smith                ";
		char[] input = str.toCharArray();
		urlify(input, 13);
		System.out.println(">" + new String(input) + "<");
		Assert.assertEquals("Mr%20John%20Smith", new String(input).trim());
		
		str = "Rahm Emmanuel is the mayor of Chicago                                         ";
		input = str.toCharArray();
		urlify(input, 37);
		System.out.println(">" + new String(input) + "<");
		Assert.assertEquals("Rahm%20Emmanuel%20is%20the%20mayor%20of%20Chicago", new String(input).trim());
		
		str = "Two space  test                                        ";
		input = str.toCharArray();
		urlify(input, 15);
		System.out.println(">" + new String(input) + "<");
		Assert.assertEquals("Two%20space%20%20test", new String(input).trim());
		
		str = "Trailing space test                                        ";
		input = str.toCharArray();
		urlify(input, 20);
		System.out.println(">" + new String(input) + "<");
		Assert.assertEquals("Trailing%20space%20test%20", new String(input).trim());
		
		str = " Leadingg space test                                        ";
		input = str.toCharArray();
		urlify(input, 20);
		System.out.println(">" + new String(input) + "<");
		Assert.assertEquals("%20Leadingg%20space%20test", new String(input).trim());
		
		System.out.println("Success");

	}

	private static void urlify(char[] input, int length){


		// Question/Assumption: trailing/leading spaces within the specified length - replace them
		// Question/Assumption: repeated spaces possible: Yes
		
		// Each occurrence of space, a character has to be replaced by %20, i.e. three characters
		// All characters after the last space will be displaced by 2 characters
		// All characters after the penultimate space  from the end will be displaced by 4 characters
		// All characters after the nth space from the end will be displaced by 2n characters.

		// Iterate over input and determine position of spaces. These are stored into spaceIndex ArrayList.
		// Initialize currentSpaceIndex = spaceIndex.size()
		// Initialize currentSpacePosition = element in currentSpaceIndex - 1
		// Iterate input array in reverse
		// If position greater than currentSpaceIndex: input[position + currentSpaceIndex*2] = input[position]
		// If position is equal to currentSpaceIndex: 
		//												input[position + currentSpaceIndex*2] = '0'
		//												input[position + currentSpaceIndex*2 - 1] = '2'
		//												input[position + currentSpaceIndex*2 - 2] = '%'
		//												currentSpaceIndex--;
		//												currentSpacePosition = element in currentSpaceIndex

		// T.C O(N)
		// S.C O(S)
		// N is the no. of elements, S is the no. of spaces

		if(input == null || input.length == 0 || length == 0)
			return;

		List<Integer> spaceIndices = new ArrayList<>();

		for(int i=0; i<length; i++){

			if(input[i] == 32)
				spaceIndices.add(i);
		}

		int currentSpaceIndex = spaceIndices.size();

		if(currentSpaceIndex == 0)
			return;

		int currentSpacePosition = spaceIndices.get(currentSpaceIndex - 1);

		for(int position=length-1; position>=0; position--){

			if(position > currentSpacePosition)
				input[position + currentSpaceIndex*2] = input[position];
			else if(position == currentSpacePosition){
				input[position + currentSpaceIndex*2] = '0';
				input[position + currentSpaceIndex*2 - 1] = '2';
				input[position + currentSpaceIndex*2 - 2] = '%';

				currentSpaceIndex--;
				if(currentSpaceIndex >=1)
					currentSpacePosition = spaceIndices.get(currentSpaceIndex - 1);
				else
					break;
			}
		}

	}

}
