class Solution {
    public int maxProfit(int[] prices) {
		int minBuyCost = 0;
		int bestDeal = 0;

		for (int i = 0; i < prices.length; i++) {
			minBuyCost = Math.min(minBuyCost, prices[i]);
			bestDeal = Math.max(bestDeal, prices[i] - minBuyCost);
		}

		return bestDeal;
    }
}
