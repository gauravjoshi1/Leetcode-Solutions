class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int sum = 0;
        int count = 0;
        int complement = 0;
        
        HashMap<Integer, Integer> rMap = new HashMap<>();
        rMap.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			complement = sum - k;
 			
 			if (rMap.containsKey(complement)) {
 				count += rMap.get(complement);
 			}
            
            if (rMap.containsKey(sum)) {
				rMap.put(sum, rMap.get(sum) + 1);
			} else {
				rMap.put(sum, 1);
			}
        }
        
        return count;
    }
}