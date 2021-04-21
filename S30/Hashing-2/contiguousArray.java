// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Example: arr = [0, 1, 0, 1] answer should be 4

Part 1: Logic:
	We create a map with 
		- key = running sum of the array
		- value = index associated with the first occurrence of running sum

	The running sum of array is computed as follows:
		if arr[i] = 1, add 1 to running sum.
		if arr[i] = 0 add -1 to running sum
		
	We compute max length of the array as follows:
		- Walkthrough the entire arr.
		- While walking through, check if running sum has previously occurred.
			if yes:
				check distance between first occur and last occur.
				update max length accordingly.
			if no:
				add the sum and associated val to arr
				
*****************************************************************************


[Come back to this after going through example walkthrough]

Part 1 Extended (Edge Case):
	We add a dummy value key = 0, val = -1 while creating the map. 
	This handles the edge case when we have equal no. of 0s and 1s. 

******************************************************************************		
Part 2: Example Walkthrough 	
	arr = [0, 1, 0, 1]
	
	max Length at index 0, arr[0]: 0
		map: {
			-1: 0
		} 
		
		running sum = -1, max length = 0 (hasn't occurred previously)
	
	max length at index 1, arr[1]: 1
		map: {
			-1: 0,
			 0: 1
		}
		
		running sum = 0,  max length = 0 (hasn't occurred previously)
	
	as we can see this is incorrect. max length should have been 2 
	since we have equal number of 1s and 0s. To fix this we add the edge case.
	
*******************************************************************************

Redoing the walkthrough with proper edge case.

arr = [0, 1, 0, 1]
	
	max Length at index 0, arr[0]: 0
		running sum = -1
		map: {
			 0: -1
			-1: 0
		} 
		
		max length = 0 (hasn't occurred previously)
	
	max length at index 1, arr[1]: 1
		running sum = 0
		map: {
			-1: 0,
			 0: -1
		}
		
		max length = 2 [1 - (-1)]. 
		
	max length at index 2, arr[2]: 0
		running sum = -1
		map: {
			-1: 0,
			 0: -1
		}
		
		max length = compare between 2 and (2 - 0) so still 2
	
		
	max length at index 3, arr[3]: 1
		running sum = 0
		map: {
			-1: 0,
			 0: -1
		}
		
		max length = compare between 2 and (3 - (-1) = 4) so 4
*/


class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int maxLength = 0;
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
        	runningSum += nums[i] == 0 ? -1 : 1;
            
        	if (sumMap.containsKey(runningSum)) {
                maxLength = Math.max(maxLength, i - sumMap.get(runningSum));
        	} else {
        		sumMap.put(runningSum, i);
        	}
        }
        
        return maxLength;
    }
}