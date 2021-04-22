// Time Complexity:  O(n) We check through the entire arr once
// Space Complexity: O(n) In worst case we end up storing n items

/*
********************************************
Example 1: nums = [1, 1, 1] k = 2
Output = 2. [1, 1] && [1, 1]

Example 2: nums = [1, 2, 3] k = 3
Output = 2. [1, 2] && [3]

*******************************************************************

Part 1: Logic:
	Maintain a running sum of all the values in the arr.
	Setup a map with: [see edge case after going through example]
		- key as the running sum at each index
 	 	- value as the num of occurrences of running sum
 	Check if the complement of running sum corresponding to k 
 	exists in map.
 		if yes:
 			then update the count 
 			
********************************************************************
 			
Edge Case:
	Put a dummy value of key = 0, val = 1 in the map at the beginning
	In our case arr = [1, 2] k = 3:
		when we check complement first, we get: 
			running sum - k = 3 - 3 = 0
		This implies that we have found two values which sum up to k.
		Instead of putting them inside map for the first time, 
		we simply update the count.  

 			
********************************************************************	

Part 2: Example Walkthrough.

arr = [1, 2, 3] k = 3
	at index = 0, arr[i] = 1, k = 3
		running sum = 1
		complement = -2
		
		complement not present in map [map is empty]
		map = {
			1 : 1
		}
		
		count = 0
	
	at index = 1, arr[i] = 2, k = 3
		running sum = 3
		complement = 0
		complement is not present in map 
		map = {
			1 : 1
			3 : 1
		}
		
		// this is incorrect. since 1 + 2 = 3. to fix this, see edge case
		count = 0  
		
		// after fix.
		count = 1  
		
		map = {
			0 : 1
			1 : 1
			3 : 1
		}
		
		
	
	at index = 2, arr[i] = 3, k = 3
		running sum = 6
		complement = 3
		complement is present in map.
		
		count = 2
		
		map = {
			1 : 1
			3 : 1
			6 : 1
		}
		
**************************************************************************
*/


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