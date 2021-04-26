// brute force solution: check all the possible combinations 
// Time Complexity: O(S^n) ---> amount^n
// Space Complexity: O(n) --> max depth of recursive stack

/*

***********************************************************
Example coins = [1, 2, 5] amount = 11

Part 1: Logic: 
	On every occassion, we have a choice.
	We choose to use either one of 1, 2, 5 or we don't
	We draw a tree representing all the choices 
	We then update amount and number of coins accordingly
	
Part 2: Example:
	coins = [1, 2, 5] amount = 11
	
	if we choose 1, amount = 10, our choices are still 1, 2, 5
	if we do not choose 1, amount = 11, our choices are 2, 5
		- if we do not choose 5, amount = 11, our choices are null
			Notice we will never get the amount using no choices 
			So we set a condition to exit here. [index >= coins.length]
		- if we choose 5, amount = 6, our choices are 5. 
			Notice even here 5 can never be used to get amount = 6.
			So we set a condition to exit here. [amount < 0]
			
****************************************************************
	
	Keep a count of minimum Steps while making a choice to 
	walk down each tree. After returning out, updated min if we
	find a shorter path
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChangeHelper(coins, amount, 0, 0);
    }
    
    private int coinChangeHelper(int[] coins, int amount, int index, int min) {
    	if (amount < 0 || index >= coins.length) return -1;
    	if (amount == 0) return min;
    	
    	int chooseCoin = coinChangeHelper(coins, amount - coins[index], index, min + 1);
    	int rejectCoin = coinChangeHelper(coins, amount, index + 1, min);
    	
    	if (chooseCoin == -1) return rejectCoin;
    	
    	if (rejectCoin == -1) return chooseCoin;
    	
    	return Math.min(chooseCoin, rejectCoin); 
    }
}


// optimized Solution

/*
**********************************************************************

Part 1: Example walkthrough 1:
		coins = [1, 2, 5] amount = 11
		
		0 1 2 3 4 5 6 7 8 9 10 11
	0   i i i i i i i i i i i   i
	1   i 1 2 3 4 5 6 7 8 9 10 11
	2   i 1 1 2 2 3 3 4 4 5 5   6
	5   i 1 1 2 2 1 2 2 3 3 2   3


i = infinity 
We observe a pattern that to get minimum number of coins at any point,	
We must utilize the following logic.
	- Know the highest denomination of coin accessible. [1, 2 or 5]
	- Go those many steps back.
	- Add 1 coin to the answer found at that step.
	
For example: [1, 2] 4 -> requires 2 steps 
This is because we go 2 step back and see [1, 2] 2 = 1. So we add 1 to it.

This effect kicks in only when the highest denomination becomes accessible.
[1, 2, 5] 4 is still 2 steps but [1, 2, 5] 5 is 1 step.

How does this solve "repeating" subproblem?
[1, 2] 4 -> if required x steps. we utilize this information to compute,
[1, 2] 6. We are not recomputing anything 

*/

class Solution {
	public int coinChange(int[] coins, int amount) {
		int[][] minCoinMatrix = new int[coins.length + 1][amount + 1];
		int row = minCoinMatrix.length;
		int col = minCoinMatrix[0].length;
		
		for (int i = 0; i < row; i++) {
			minCoinMatrix[i][0] = 0;
		} 
	
		for (int i = 0; i < col; i++) {
			minCoinMatrix[0][i] = 9999;
		}
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (j < coins[i - 1]) {
					minCoinMatrix[i][j] = minCoinMatrix[i - 1][j];
				} else {
					minCoinMatrix[i][j] = Math.min(minCoinMatrix[i - 1][j], minCoinMatrix[i][j - coins[i - 1]] + 1);
				}			
			}
		}
		
		int result = minCoinMatrix[row - 1][col - 1];
		return result == 9999 ? -1 : result; 
	}
}