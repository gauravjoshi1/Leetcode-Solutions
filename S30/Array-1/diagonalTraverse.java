/******************************************************

## Logic:

To solve this question, we need to make two important observations.

1. If you cannot go up right then
    - go to right.
    - if you cannot go right then go down.

    change direction either ways.

2. If you cannot go down left then
    - go down
    - if cannot go down then go right.

    change direction either ways.

We deduce this by looking at the arrow marks on the example image.


******************************************************/

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
    	if (mat == null || mat.length == 0) return new int[]{};
    	int m = mat.length;
    	int n = mat[0].length;
    	int[] result = new int[m * n];
    	int row = 0;
    	int col = 0;
    	boolean direction = true;
    	
    	for (int i = 0; i < m * n; i++) {
    		result[i] = mat[row][col];
    		
    		if (direction) {
    			if (col == n - 1) {
    				row++;
    				direction = false;
    			} else if (row == 0) {
    				col++;
    				direction = false;
    			} else {
    				row--;
    				col++;
    			}
    		} else {
    			if (row == m - 1) {
    				col++;
    				direction = true;
    			} else if (col == 0) {
    				row++;
    				direction = true;
    			} else {
    				row++;
    				col--;
    			}
    		}
    	}
    	
    	return result;
    	 
    }
}