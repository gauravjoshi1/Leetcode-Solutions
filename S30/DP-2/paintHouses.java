/*****************************************************************************
 
 1. Brute force Solution:
 
 Example: 
		r	b	g 
h1: 	17	2	17
h2: 	16	16	5	
h3: 	14	3	10

h1 -> 2. h2 -> 5. h3 -> 3. total = 10

start with one path. 

if we choose red for h1. 
	choose blue for h2 or choose green for h2.
	for both blue and green we have two choices each.

Explore every path
Time Complexity: O(2^n)	
Space Complexity: O(n) <--- Recursive Stack 

*****************************************************************************

 2. DP Solution

Create a matrix that stores the minimum sum at each index.
For our example:

 Example: 
		r							b			g 
h1: 	17							2			17
h2: 	16 + min(2, 17) = 18		33			5 + min(2, 17) = 7	
h3: 	14 + min(33, 7) = 21		10			10 + min(33, 18) = 28w
  

Time Complexity: O(n) <-- number of houses [since colors are constant]
Space Complexity: O(n) <-- number of houses [assuming cost arr is immutable] 
							otherwise, O(1).
*****************************************************************************/

/***********************IMMUTABLE ARRAY*************************************/


class Solution {
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) return 0;
		int row = costs.length;
		int col = 3;
		
		int[][] costMatrix = new int[row][col];
		
		// copy the first row from cost as there's no minimium to compare 
		for (int i = 0; i < col; i++){
			costMatrix[0][i] = costs[0][i];
		}
		
		for (int i = 1; i < row; i++) {
			costMatrix[i][0] = cost[i][0] + Math.min(costMatrix[i - 1][1], costMatrix[i - 1][2]);
			costMatrix[i][1] = cost[i][1] + Math.min(costMatrix[i - 1][0], costMatrix[i - 1][2]);
			costMatrix[i][2] = cost[i][2] + Math.min(costMatrix[i - 1][0], costMatrix[i - 1][1]);
		}	
		
		return Math.min(costMatrix[row - 1][0], costMatrix[row - 1][1], costMatrix[row - 1][2]);
	}
} 

/*************************MUTABLE ARRAY*************************************/

class Solution {
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) return 0;
		int row = costs.length;
		
		for (int i = 1; i < row; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);  
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);  
			costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);  
		}
		
		return Math.min(costs[row - 1][0], costs[row - 1][1], costs[row - 1][2]); 
	}
}
