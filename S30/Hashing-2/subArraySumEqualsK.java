class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int sum = 0;
        int count = 0;
        int compliment = 0;
        
        HashMap<Integer, Integer> rMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			compliment = sum - k;
			
			if (rMap.containsKey(sum)) {
				rMap.put(sum, rMap.get(sum) + 1);
			} else {
				rMap.put(sum, 1);
			}
 			
 			if (rMap.containsKey(compliment)) {
 				count += rMap.get(compliment);
 			}
        }
        
        return count;
    }
}