/************************************************************

We break down the original nums array into left sub array and 
right sub array. 

The left product is calculated by iterating left to right. 
The right product is calculated by iterating from right to left.


Example: nums = [1, 2, 3, 4]

Left Sub Array Product  =  [1, 1, 2, 6] 
Right Sub Array Product  = [24, 12, 4, 1]

The product of left & right = [24, 12, 8, 6] is the answer 


Time Complexity: O(n)
Space Complexity: O(1) // returning array doesn't count

************************************************************/

class Solution {
    public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) return nums;
		
		int[] arr = new int[nums.length];
		int frontPtr = 1;
		int backPtr = 1;
		
		for (int i = 0; i < nums.length; i++) {
			arr[i] = frontPtr;
			frontPtr *=  nums[i];
		}
		
		for (int i = nums.length - 1; i >= 0; i--) {
			arr[i] *= backPtr;
			backPtr *= nums[i];
		}        
		
		return arr;
    }
}