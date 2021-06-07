/*************************************************************

## Logic:

Create 4 separate pointers to take care of the 4 directions (left, right, top, bottom).

1. Move from left → right. [update top as the top row is done]
2. Move top → bottom [update right as right column is done]
3. Move right → left [update bottom as bottom row is done]
4. Move bottom → top [update left as left column is done]

The above four steps are repeated until either top or left pointer cross bottom or right pointer respectively. [Meaning the spiral array is done]

### Subtle Bug

There is a subtle bug in the above code. 

In the 3rd and 4th step ensure top and left pointer haven't crossed bottom and right pointer before moving right → left and bottom → top.

*************************************************************/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) return result;
        
        int top = 0, left = 0;
        int bottom = matrix.length - 1, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
        	for (int i = left; i <= right; i++) {
        		result.add(matrix[top][i]);
        	} 
        	
        	top++;
        	
        	for (int i = top; i <= bottom; i++) {
        		result.add(matrix[i][right]);
        	}
        	
        	right--;
        	
        	if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					result.add(matrix[bottom][i]);
				}
		    	   	
		    	bottom--;
        	}
        	
        	if (left <= right) {
		    	for (int i = bottom; i >= top; i--) {
		    		result.add(matrix[i][left]);
		    	}
		    	
		    	left++;
        	}
        }
        
        return result;
    }
}