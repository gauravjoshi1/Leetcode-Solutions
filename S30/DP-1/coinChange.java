// brute force solution: check all the possible combinations 

class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChangeHelper();
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

class Solution {
	public int coinChange(int[] coins, int amount) {
		return -1;
	}
}