package com.rolex.ctci.ch1_arrays_and_strings.q1_8;

import junit.framework.Assert;

/* 
 * Zero Matrix: Write an algorithm such that if an element in an M x N matrix is 0, 
 * its entire row and column are set to 0.
 */
public class SolutionV2 {

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
			{17, 0,19,20,21,22},
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

	// In place solution with O(1) space usage
	private static void zeroMatrix(int[][] matrix) {
		
		// Identify whether the top row has a zero and the left most column has a zero
		// Set flags to track the above.
		// Use the top row and left most row to track the row and column positions that have zero
		// Whenever a 0 is encountered in i,j, set ith row in left most column as zero and 
		// jth column in top most row as 0
		// Iterate over the top row and left most column and set the entire row/column to zero
		// whenever a zero is seen
		// Check the flags for top row zero and left column zero and set all zeroes in top row
		// left column as required.
		
		// T.C. O(M*N)
		// S.C. O(1)
		
		boolean topRowHasZero = false;
		boolean leftColumnHasZero = false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		for(int i=0; i<m; i++){
			if(matrix[i][0] == 0){
				leftColumnHasZero = true;
				break;
			}
		}
		
		for(int j=0; j<n; j++){
			if(matrix[0][j] == 0){
				topRowHasZero = true;
				break;
			}
		}
		
		for(int a=1; a<m; a++){
			for(int b=1; b<n; b++){
				if(matrix[a][b] == 0){
					matrix[a][0] = 0;
					matrix[0][b] = 0;
				}
			}
		}
		
		for(int x=0; x<m; x++){
			if(matrix[x][0] == 0){
				for(int y=1; y<n; y++){
					matrix[x][y] = 0;
				}
			}
		}
		
		for(int s=0; s<n; s++){
			if(matrix[0][s] == 0){
				for(int t=1; t<m; t++){
					matrix[t][s] = 0;
				}
			}
		}
		
		if(topRowHasZero){
			for(int e=0; e<n; e++){
				matrix[0][e] = 0;
			}
		}
		
		if(leftColumnHasZero){
			for(int f=0; f<m; f++){
				matrix[f][0] = 0;
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
