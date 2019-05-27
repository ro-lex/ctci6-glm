package com.rolex.ctci.ch1_arrays_and_strings.q1_7;

import junit.framework.Assert;

/*
 * Rotate Matrix: Given an image represented by an NXN matrix, 
 * where each pixel in the image is represented by an integer,
 * write a method to rotate the image by 90 degrees. Can you do
 * this in place?
 */
public class SolutionV1 {

	public static void main(String[] args) {

		int[][] matrix = {
			{0,1,2},
			{3,4,5},
			{6,7,8}
		};

		int[][] result = rotateMatrix(matrix);
		/* Result:
		{
			{6,3,0},
			{7,4,1},
			{8,5,2}
		};
		 */

		Assert.assertEquals(6, result[0][0]);
		Assert.assertEquals(3, result[0][1]);
		Assert.assertEquals(0, result[0][2]);
		Assert.assertEquals(7, result[1][0]);
		Assert.assertEquals(4, result[1][1]);
		Assert.assertEquals(1, result[1][2]);
		Assert.assertEquals(8, result[2][0]);
		Assert.assertEquals(5, result[2][1]);
		Assert.assertEquals(2, result[2][2]);

		matrix = new int[][] {
			{1,2,3},
			{4,5,6}
		};

		result = rotateMatrix(matrix);
		/* Result		
		{
			{4,1},
			{5,2},
			{6,3}
		}
		 */

		Assert.assertEquals(4, result[0][0]);
		Assert.assertEquals(1, result[0][1]);
		Assert.assertEquals(5, result[1][0]);
		Assert.assertEquals(2, result[1][1]);
		Assert.assertEquals(6, result[2][0]);
		Assert.assertEquals(3, result[2][1]);

		matrix = new int[][] {
			{1,2},
			{3,4},
			{5,6}
		};

		result = rotateMatrix(matrix);
		/* Result
		{
			{5,3,1},
			{6,4,2}
		}
		*/

		Assert.assertEquals(5, result[0][0]);
		Assert.assertEquals(3, result[0][1]);
		Assert.assertEquals(1, result[0][2]);
		Assert.assertEquals(6, result[1][0]);
		Assert.assertEquals(4, result[1][1]);
		Assert.assertEquals(2, result[1][2]);

		matrix = new int[][] {
			{11,12,13,14,15,16},
			{17,18,19,20,21,22},
			{23,24,25,26,27,28},
			{29,30,31,32,33,34},
			{35,36,37,38,39,40},
			{41,42,43,44,45,46}
		};

		result = rotateMatrix(matrix);
		/* Result
		{
			{41,35,29,23,17,11},
			{42,36,30,24,18,12},
			{43,37,31,25,19,13},
			{44,38,32,26,20,14},
			{45,39,33,27,21,15},
			{46,40,34,28,22,16}
		}
		*/

		Assert.assertEquals(41, result[0][0]);
		Assert.assertEquals(35, result[0][1]);
		Assert.assertEquals(29, result[0][2]);
		Assert.assertEquals(23, result[0][3]);
		Assert.assertEquals(17, result[0][4]);
		Assert.assertEquals(11, result[0][5]);
		Assert.assertEquals(42, result[1][0]);
		Assert.assertEquals(36, result[1][1]);
		Assert.assertEquals(30, result[1][2]);
		Assert.assertEquals(24, result[1][3]);
		Assert.assertEquals(18, result[1][4]);
		Assert.assertEquals(12, result[1][5]);
		Assert.assertEquals(43, result[2][0]);
		Assert.assertEquals(37, result[2][1]);
		Assert.assertEquals(31, result[2][2]);
		Assert.assertEquals(25, result[2][3]);
		Assert.assertEquals(19, result[2][4]);
		Assert.assertEquals(13, result[2][5]);
		Assert.assertEquals(44, result[3][0]);
		Assert.assertEquals(38, result[3][1]);
		Assert.assertEquals(32, result[3][2]);
		Assert.assertEquals(26, result[3][3]);
		Assert.assertEquals(20, result[3][4]);
		Assert.assertEquals(14, result[3][5]);
		Assert.assertEquals(45, result[4][0]);
		Assert.assertEquals(39, result[4][1]);
		Assert.assertEquals(33, result[4][2]);
		Assert.assertEquals(27, result[4][3]);
		Assert.assertEquals(21, result[4][4]);
		Assert.assertEquals(15, result[4][5]);
		Assert.assertEquals(46, result[5][0]);
		Assert.assertEquals(40, result[5][1]);
		Assert.assertEquals(34, result[5][2]);
		Assert.assertEquals(28, result[5][3]);
		Assert.assertEquals(22, result[5][4]);
		Assert.assertEquals(16, result[5][5]);

		System.out.println("Success");
	}

	// Solution using an additional data structure top copy the elements
	// Although the question specifies N X N, this solution solves for generic M X N
	// matrices.
	private static int[][] rotateMatrix(int[][] matrix) {

		// Assume: the elements are integer, and are unique values so that the result
		// can be tested for correctness.
		// Question: are the dimensions square? i.e. row and column count are the same?
		// Assume No.
		// Question: Which direction should the array be rotated - Assume clockwise

		// Iterate over the MXN matrix
		// Resultant matrix dimension will be NXM
		// Initially the resultant matrix column count will be 'M-1'.
		// This will be decremented for each new row in the given matrix.
		// Resultant matrix row count will be iterated over 0 to N-1.
		// This will be incremented for every element in the given matrices row. Reset
		// to 0 for each new row.
		// For every row in the given matrix, resultant value will be
		// [newRowCount][newCoulmnCount]

		// T.C. O(M*N)
		// S.C O(M+N)
		// where M, is the no. of rows and N is the no. of columns

		if (matrix == null || matrix.length == 0)
			return matrix;

		final int m = matrix.length;
		final int n = matrix[0].length;

		int[][] result = new int[n][m];

		int column = m; // resultant column count is m

		for (int i = 0; i < m; i++) {

			column--;

			for (int j = 0; j < n; j++) {
				result[j][column] = matrix[i][j];
			}
		}

		return result;
	}
}
