class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int maxLength = 0;
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
        	runningSum += nums[i] == 0 ? -1 : 1;
        	
        	if (sumMap.contains(runningSum)) {
        		if (maxLength < i - sumMap.get(runningSum) {
        			maxLength = i - sumMap.get(runningSum);
        		}
        	} else {
        		runningSum.put(runningSum, i);
        	}
        }
        
        return maxLength;
    }
}