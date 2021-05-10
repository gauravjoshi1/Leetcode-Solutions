/*****************************************************************************
 
 1. Brute force Solution:
 
 Example: arr = [1, 2, 5] amount = 5. 
 1 + 1 + 1 + 1 + 1 = 5
 1 + 1 + 1 + 2 = 5
 1 + 2 + 2 = 5
 5 = 5

 combinations = 5
 
 At every point we have two options. To choose or reject a coin.
 if we choose, we reduce the amount. if we don't, we move 1 index up. 

 Eventually we return the total number of combinations

*****************************************************************************

 2. DP Solution
 
 What is the repeating sub-problem?
 -> in our example:
 if we choose 1 twice then don't choose 1, 
 	our arr is: [2, 5] remaining amount = 3.
 if we reject 1 then choose 2 once, 
 	our arr is: [2, 5] remaining amount = 3.
 
 We have the same branch that we are tracking repeatedly.
 
 We want to 'store' this repeated path in memory to avoid repeated checks.
 
 At (2, 4) we go back to (2, 2) [which is 2] and add 1 to it.
 
 0 1 2 3 4 5
 1 1 1 1 1 1 
 2 1 2 2 3 3
 5 1 2 2 3 4 
 
*****************************************************************************/


class Solution {
	public int change(int amount, int[] coins) {
        return coinChangeHelper(coins, amount, 0);
    }
    
    private int coinChangeHelper(int[] coins, int amount, int index) {
    	if (amount < 0 || index >= coins.length) return 0;
    	
    	if (amount == 0) return 1;
    
    	int choose = coinChangeHelper(coins, amount - coins[index], index);
    	int reject = coinChangeHelper(coins, amount, index + 1);
    	
    	return choose + reject;
    }
}

class Solution {
	public int change(int amount, int[] coins) {
		int row = coins.length + 1
		int col = amount + 1;
		
		int[][] amountMatrix = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			amountMatrix[i][0] = 1;
		}
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (j < coins[i - 1]) {
					amountMatrix[i][j] = amountMatrix[i - 1][j];
				} else {
					amountMatrix[i][j] = amountMatrix[i - 1][j] + amountMatrix[i][j - coins[i - 1]];
				}
			}
		}
		
		return amountMatrix[row - 1][col - 1];
	}
}

