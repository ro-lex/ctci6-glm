package com.rolex.ctci.ch1_arrays_and_strings.q1_8;

import java.util.Set;
import java.util.HashSet;

import junit.framework.Assert;

/* 
 * Zero Matrix: Write an algorithm such that if an element in an M x N matrix is 0, 
 * its entire row and column are set to 0.
 */
public class SolutionV1 {

	public static void main(String[] args) {

		int[][] matrix = { { 0 } };
		zeroMatrix(matrix);
		print(matrix);
		Assert.assertEquals(0, matrix[0][0]);

		matrix = new int[][] { 
			{ 1, 2, 3 },
			{ 4, 0, 6 } 
		};

		zeroMatrix(matrix);
		print(matrix);

		Assert.assertEquals(1, matrix[0][0]);
		Assert.assertEquals(0, matrix[0][1]);
		Assert.assertEquals(3, matrix[0][2]);
		Assert.assertEquals(0, matrix[1][0]);
		Assert.assertEquals(0, matrix[1][1]);
		Assert.assertEquals(0, matrix[1][2]);

		matrix = new int[][] { 
			{ 0, 2, 3 }, 
			{ 4, 0, 6 } 
		};

		zeroMatrix(matrix);
		print(matrix);

		Assert.assertEquals(0, matrix[0][0]);
		Assert.assertEquals(0, matrix[0][1]);
		Assert.assertEquals(0, matrix[0][2]);
		Assert.assertEquals(0, matrix[1][0]);
		Assert.assertEquals(0, matrix[1][1]);
		Assert.assertEquals(0, matrix[1][2]);
		
		matrix = new int[][] {
			{11,12,13,14,15,16},
			{17,0,19,20,21,22},
			{23,24,25,26,27,28},
			{29,30,31,32,33,0}
		};
		
		zeroMatrix(matrix);
		print(matrix);
		
		Assert.assertEquals(11, matrix[0][0]);
		Assert.assertEquals(0, matrix[0][1]);
		Assert.assertEquals(13, matrix[0][2]);
		Assert.assertEquals(14, matrix[0][3]);
		Assert.assertEquals(15, matrix[0][4]);
		Assert.assertEquals(0, matrix[0][5]);
		Assert.assertEquals(0, matrix[1][0]);
		Assert.assertEquals(0, matrix[1][1]);
		Assert.assertEquals(0, matrix[1][2]);
		Assert.assertEquals(0, matrix[1][3]);
		Assert.assertEquals(0, matrix[1][4]);
		Assert.assertEquals(0, matrix[1][5]);
		Assert.assertEquals(23, matrix[2][0]);
		Assert.assertEquals(0, matrix[2][1]);
		Assert.assertEquals(25, matrix[2][2]);
		Assert.assertEquals(26, matrix[2][3]);
		Assert.assertEquals(27, matrix[2][4]);
		Assert.assertEquals(0, matrix[2][5]);
		Assert.assertEquals(0, matrix[3][0]);
		Assert.assertEquals(0, matrix[3][1]);
		Assert.assertEquals(0, matrix[3][2]);
		Assert.assertEquals(0, matrix[3][3]);
		Assert.assertEquals(0, matrix[3][4]);
		Assert.assertEquals(0, matrix[3][5]);

		matrix = new int[][] {
			{11,12,13,14,15,16},
			{17, 0, 0,20,21,22},
			{23,24,25,26,27,28},
			{29,30,31,32,33,0}
		};
		
		zeroMatrix(matrix);
		print(matrix);
		
		Assert.assertEquals(11, matrix[0][0]);
		Assert.assertEquals(0, matrix[0][1]);
		Assert.assertEquals(0, matrix[0][2]);
		Assert.assertEquals(14, matrix[0][3]);
		Assert.assertEquals(15, matrix[0][4]);
		Assert.assertEquals(0, matrix[0][5]);
		Assert.assertEquals(0, matrix[1][0]);
		Assert.assertEquals(0, matrix[1][1]);
		Assert.assertEquals(0, matrix[1][2]);
		Assert.assertEquals(0, matrix[1][3]);
		Assert.assertEquals(0, matrix[1][4]);
		Assert.assertEquals(0, matrix[1][5]);
		Assert.assertEquals(23, matrix[2][0]);
		Assert.assertEquals(0, matrix[2][1]);
		Assert.assertEquals(0, matrix[2][2]);
		Assert.assertEquals(26, matrix[2][3]);
		Assert.assertEquals(27, matrix[2][4]);
		Assert.assertEquals(0, matrix[2][5]);
		Assert.assertEquals(0, matrix[3][0]);
		Assert.assertEquals(0, matrix[3][1]);
		Assert.assertEquals(0, matrix[3][2]);
		Assert.assertEquals(0, matrix[3][3]);
		Assert.assertEquals(0, matrix[3][4]);
		Assert.assertEquals(0, matrix[3][5]);
		
		matrix = new int[][] {
			{11,12,13,14, 0,16},
			{17, 0, 0,20,21,22},
			{23,24,25,26,27,28},
			{29,30,31,32,33,0}
		};
		
		zeroMatrix(matrix);
		print(matrix);
		
		Assert.assertEquals(0, matrix[0][0]);
		Assert.assertEquals(0, matrix[0][1]);
		Assert.assertEquals(0, matrix[0][2]);
		Assert.assertEquals(0, matrix[0][3]);
		Assert.assertEquals(0, matrix[0][4]);
		Assert.assertEquals(0, matrix[0][5]);
		Assert.assertEquals(0, matrix[1][0]);
		Assert.assertEquals(0, matrix[1][1]);
		Assert.assertEquals(0, matrix[1][2]);
		Assert.assertEquals(0, matrix[1][3]);
		Assert.assertEquals(0, matrix[1][4]);
		Assert.assertEquals(0, matrix[1][5]);
		Assert.assertEquals(23, matrix[2][0]);
		Assert.assertEquals(0, matrix[2][1]);
		Assert.assertEquals(0, matrix[2][2]);
		Assert.assertEquals(26, matrix[2][3]);
		Assert.assertEquals(0, matrix[2][4]);
		Assert.assertEquals(0, matrix[2][5]);
		Assert.assertEquals(0, matrix[3][0]);
		Assert.assertEquals(0, matrix[3][1]);
		Assert.assertEquals(0, matrix[3][2]);
		Assert.assertEquals(0, matrix[3][3]);
		Assert.assertEquals(0, matrix[3][4]);
		Assert.assertEquals(0, matrix[3][5]);

		System.out.println("Success");

	}

	// In place solution
	private static void zeroMatrix(int[][] matrix) {

		// Questions:
		// Are elements all integers? Assume yes.
		// Should replacements be in place? Assume yes.
		// Is it a square matrix? No, specified in the question

		// Locate occurrences of zeroes: { {row, column}, ...}
		// Keep row constant and iterate over columns and set to 0
		// Keep column constant and iterate over rows and set to 0

		// T.C. O(M*N)
		// S.C. O(c), 
		// where c is the no. of 0's and M and N are the dimensions of the matrix.

		if (matrix == null || matrix.length == 0)
			return;

		int m = matrix.length;
		int n = matrix[0].length;

		Set<Integer> rows = new HashSet<>();
		Set<Integer> columns = new HashSet<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					columns.add(j);
					//break;
				}
			}
		}

		for (int row : rows) {
			for (int a = 0; a < n; a++) {
				matrix[row][a] = 0;
			}
		}

		for (int column : columns) {
			for (int b = 0; b < m; b++) {
				matrix[b][column] = 0;
			}
		}
	}

	private static void print(int[][] matrix) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {

			count = 0;

			for (int j = 0; j < matrix[0].length; j++) {
				String value = String.valueOf(matrix[i][j]).length() == 1 ? (" " + String.valueOf(matrix[i][j])) : String.valueOf(matrix[i][j]);
				count += value.length() + 3;
				System.out.print(value + " | ");
			}

			System.out.println();
		}

		StringBuilder separator = new StringBuilder(count);
		for (int i = 0; i < count - 1; i++)
			separator.append("-");

		System.out.println(separator);
	}

}
