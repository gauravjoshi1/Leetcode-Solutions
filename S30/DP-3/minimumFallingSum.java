/**********************************************************************

1. Approach

Cache the min sum in memory at each element.
		sum arr:
2 1 3	2    1    3
6 5 4	7    6    5
7 8 9   13   13   14

2. Repeating Sub problem?

The simple Approach would be to follow the entire recursive tree.

2 -> 6 -> 7
2 -> 6 -> 8
2 -> 5 -> 8
2 -> 5 -> 9

We can see that we are computing the sum of 2 and 6 or 2 and 5
again. This happens with all the elements resulting in time
complexity (3^n). Since on average (and in worst case scenario) 
we have to choose between 3 branches.


We reduce this sub problem by caching the sum in the memory (2d arr).
The resulting time complexity is (n^2 or m * n if not a matrix).

If we don't want to change existing array the space complexity is (n^2)
otherwise O(1).



************************************************************************/


class Solution {
    public int minFallingPathSum(int[][] matrix) {
    	if (matrix == null || matrix.length == 0) return 0;
    
		int row = matrix.length;
		int col = matrix[0].length;    	
		int min = Integer.MAX_VALUE;
    	
    	int[][] minSumMatrix = new int[row][col];
    	
    	
    	// copy everything for the first row
    	for (int i = 0; i < col; i++) {
    		minSumMatrix[0][i] = matrix[0][i];
    	}
    	
    	for (int i = 1; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			if (j == 0) {
					minSumMatrix[i][j] = matrix[i][j] + Math.min(minSumMatrix[i - 1][j], minSumMatrix[i - 1][j + 1]);
    			} else if (j == row - 1) {
    				minSumMatrix[i][j] = matrix[i][j] + Math.min(minSumMatrix[i - 1][j - 1], minSumMatrix[i - 1][j]);
    			} else {
    				minSumMatrix[i][j] = matrix[i][j] + Math.min(Math.min(minSumMatrix[i - 1][j - 1], minSumMatrix[i - 1][j]), minSumMatrix[i - 1][j + 1]);
    			}	
    		}
    	}
    	
    	for (int i = 0; i < row; i++) {
    		if (minSumMatrix[col - 1][i] < min) {
    			min = minSumMatrix[col - 1][i];
    		}
    	}
    	
    	return min;
    }
}