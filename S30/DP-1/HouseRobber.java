/*
1.	Brute Force Algorithm: 
	Example nums = [5, 10, 4, 20]
	At each instance we can either choose or not choose a particular value. 
	If we choose: then we skip 1 index.
	
	Time Complexity: O(2^n)
	Space Complexity: O(n) --- Depth of the recursive stack

2. DP Solution:

What is the repeating sub-problem here?
-> For the above example:
	5 + 4 = 9 & 
	5 + 20 = 25 is one comparison we make 
	
	We also compare 4 & 20 separately. 
	
	Instead, we can 'store' the sum as part of choose or reject to 
	reduce number of checks.

	
	Furthermore, we only care about biggest value of robs.
	So, if we skip a house, we only skip it because the prev house
	had bigger cumulative (uptil that point) sum.
*/


class Solution {

/********** BRUTE FORCE SOLUTION *********************** 
 

	public int rob(int[] nums) {
		return robHelper(nums, 0, 0);
	} 
	
	private int robHelper(int[] nums, int index, int sum) {
		if (index >= nums.length) return sum;
		
		int chooseRob = robHelper(nums, index + 2, sum + nums[index]);
		int rejectRob = robHelper(nums, index + 1, sum);
		
		return Math.max(chooseRob, rejectRob);
	}
	
********************************************************/

	public int rob(int[] nums) {
		int reject = 0;
		int choose = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			int temp = reject;
			reject = Math.max(choose, reject);
			choose = temp + nums[i];
		
		}
		
		return Math.max(chooseRob, rejectRob);
	} 
}