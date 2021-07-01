/************************************************************

// Time Complexity O(n)
// Space Complexity O(n)

Logic:
1. Store the complement of target in the map
2. Check if the complement in map is present in array:
	- Check if it's index is not the same the value itself
	Example: [3, 2, 4] target = 6.
	Here 3 is the val and 3 is the complement but both
	have same index.

3. Return the index and index of complement.

************************************************************/


class Solution {
    public int[] twoSum(int[] nums, int target) {

		if (nums == null || nums.length == 0) return new int[]{};

		HashMap<Integer, Integer> hMap = new HashMap<>();
		int[] arr = new int[2];

		for (int i = 0; i < nums.length; i++) {
			hMap.put(target - nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (hMap.containsKey(nums[i]) && hMap.get(nums[i]) != i) {
				return new int[]{i, hMap.get(nums[i])};
			}
		}

		return arr;
    }
}
