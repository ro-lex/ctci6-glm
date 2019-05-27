package com.rolex.ctci.ch1_arrays_and_strings.q1_7;

import junit.framework.Assert;

/*
 * Rotate Matrix: Given an image represented by an NXN matrix, 
 * where each pixel in the image is represented by an integer,
 * write a method to rotate the image by 90 degrees. Can you do
 * this in place?
 */
public class SolutionV3 {

	public static void main(String[] args) {

		int[][] matrix = { 
			{0,1,2},
			{3,4,5},
			{6,7,8}
		};

		rotateMatrix(matrix);
		/* Result:
		{
			{6,3,0},
			{7,4,1},
			{8,5,2}
		};
		 */

		Assert.assertEquals(6, matrix[0][0]);
		Assert.assertEquals(3, matrix[0][1]);
		Assert.assertEquals(0, matrix[0][2]);
		Assert.assertEquals(7, matrix[1][0]);
		Assert.assertEquals(4, matrix[1][1]);
		Assert.assertEquals(1, matrix[1][2]);
		Assert.assertEquals(8, matrix[2][0]);
		Assert.assertEquals(5, matrix[2][1]);
		Assert.assertEquals(2, matrix[2][2]);

		matrix = new int[][] {
			{11,12,13,14,15,16},
			{17,18,19,20,21,22},
			{23,24,25,26,27,28},
			{29,30,31,32,33,34},
			{35,36,37,38,39,40},
			{41,42,43,44,45,46}
		};

		rotateMatrix(matrix);
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

		Assert.assertEquals(41, matrix[0][0]);
		Assert.assertEquals(35, matrix[0][1]);
		Assert.assertEquals(29, matrix[0][2]);
		Assert.assertEquals(23, matrix[0][3]);
		Assert.assertEquals(17, matrix[0][4]);
		Assert.assertEquals(11, matrix[0][5]);
		Assert.assertEquals(42, matrix[1][0]);
		Assert.assertEquals(36, matrix[1][1]);
		Assert.assertEquals(30, matrix[1][2]);
		Assert.assertEquals(24, matrix[1][3]);
		Assert.assertEquals(18, matrix[1][4]);
		Assert.assertEquals(12, matrix[1][5]);
		Assert.assertEquals(43, matrix[2][0]);
		Assert.assertEquals(37, matrix[2][1]);
		Assert.assertEquals(31, matrix[2][2]);
		Assert.assertEquals(25, matrix[2][3]);
		Assert.assertEquals(19, matrix[2][4]);
		Assert.assertEquals(13, matrix[2][5]);
		Assert.assertEquals(44, matrix[3][0]);
		Assert.assertEquals(38, matrix[3][1]);
		Assert.assertEquals(32, matrix[3][2]);
		Assert.assertEquals(26, matrix[3][3]);
		Assert.assertEquals(20, matrix[3][4]);
		Assert.assertEquals(14, matrix[3][5]);
		Assert.assertEquals(45, matrix[4][0]);
		Assert.assertEquals(39, matrix[4][1]);
		Assert.assertEquals(33, matrix[4][2]);
		Assert.assertEquals(27, matrix[4][3]);
		Assert.assertEquals(21, matrix[4][4]);
		Assert.assertEquals(15, matrix[4][5]);
		Assert.assertEquals(46, matrix[5][0]);
		Assert.assertEquals(40, matrix[5][1]);
		Assert.assertEquals(34, matrix[5][2]);
		Assert.assertEquals(28, matrix[5][3]);
		Assert.assertEquals(22, matrix[5][4]);
		Assert.assertEquals(16, matrix[5][5]);

		matrix = null;
		rotateMatrix(matrix);
		Assert.assertEquals(null, matrix);

		matrix = new int[][] {
			{1,2,3},
			{4,5,6}
		};

		try {
			rotateMatrix(matrix);
		} catch (NotASquareMatrixException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Not a square matrix. Cannot be rotated in place.", e.getMessage());
		}

		System.out.println("Success");

	}

	// In place solution, without using additional array
	private static void rotateMatrix(int[][] matrix) {

		// Assume: the elements are integer, and are unique values so that the result
		// can be tested for correctness.
		// Question: are the dimensions square? i.e. row and column count are the same?
		// Assume Yes.
		// Question: Which direction should the array be rotated - Assume clockwise

		// Iterate from counter min to max - 1
		// Copy top row first cell into a temp variable.
		// Copy each corner into the next corner. Use temp variable to fill the last
		// corner
		// Decrement counter and perform for next set of cells
		// Repeat for inner layers.

		// Bounding Co-ordinates: matrix[min][min], matrix[min, max], matrix[max, max],
		// matrix[max, min]
		// Initially: min = 0, max = N-1 (i.e. 0 based array positions)
		// pos = min
		// While pos < max
		// temp = matrix[min][pos]
		// matrix[min][pos] = matrix[max - pos + min][min]
		// matrix[max - pos + min][min] = matrix[max][max - pos + min]
		// matrix[max][max - pos + min] = matrix[pos][max]
		// matrix[pos][max] = temp
		// Increment pos
		// Increment min and decrement max
		// Break when min >= max
		// For even N, the last grid will be a 2 X 2 matrix, for odd N, the last grid
		// will be a single cell

		// T.C. N/2 iterations of the while loop (for even N)
		// T.C. = (N - 1) + (N-3) + .. 1
		// [first calls executes 5 for loops, each N-1 times. last call executes 2*2
		// matrix. i.e. N-1 = 1]
		// = (N-1 + N-3 + .. + 1) = (N-1 + N-3 + ... + N-(N-1))
		// = (N*N/2 - (1 + 3 + .. + N-1))
		// Sum of n even no.s = n(n+1)
		// Sum of n odd no.s = N(N+1)/2 - n(n+1). Where N = Max of odd no. + 1
		// T.C. = (N*N/2 - (N(N+1)/2 - N/2 * (N/2 + 1)))
		// = ( N*N/2 - (N*N/2 + N/2 - N*N/4 - N/2)) = (N*N/4)
		// T.C = O(N*N), this is the best possible T.C as each element needs to be
		// visited once.
		// S.C. O(1)

		if (matrix == null || matrix.length == 0)
			return;

		if (matrix.length != matrix[0].length)
			throw new NotASquareMatrixException("Not a square matrix. Cannot be rotated in place.");

		int min = 0;
		int max = matrix.length - 1;
		print(matrix);

		while (min < max) {
			rotateCellsInALayer(matrix, min, max);
			print(matrix);
			min++;
			max--;
		}
	}

	private static void rotateCellsInALayer(int[][] matrix, int min, int max) {

		int pos = min;

		while (pos < max) {

			int temp = matrix[min][pos];
			matrix[min][pos] = matrix[max - pos + min][min];
			matrix[max - pos + min][min] = matrix[max][max - pos + min];
			matrix[max][max - pos + min] = matrix[pos][max];
			matrix[pos][max] = temp;
			pos++;
		}

	}

	private static void print(int[][] matrix) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {

			count = 0;

			for (int j = 0; j < matrix[0].length; j++) {
				count += String.valueOf(matrix[i][j]).length() + 3;
				System.out.print(matrix[i][j] + " | ");
			}

			System.out.println();
		}

		StringBuilder separator = new StringBuilder(count);
		for (int i = 0; i < count - 1; i++)
			separator.append("-");

		System.out.println(separator);
	}

	private static class NotASquareMatrixException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public NotASquareMatrixException(String message) {
			super(message);
		}
	}

}