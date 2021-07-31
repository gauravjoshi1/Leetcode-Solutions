// Backtracking Solution

/************************************************************

Check all possible combination of jumps available.
-> max_jump = minimum(index + val_at_index, lastArrayIndex)

We check 2^n combinations (for each element we check if

************************************************************/

// 	class Solution {
// 		public boolean canJump(int[] nums) {
// 			return canJumpHelper(nums, 0);
// 		}
//
// 		private boolean canJumpHelper(int[] nums, int position) {
// 			if (position == nums.length - 1) return true;
// 			int maxJump = Math.min(nums[position] + position, nums.length - 1);
//
// 			for (int i = position + 1; i <= maxJump; i++) {
// 				if (canJumpHelper(nums, i)) {
// 					return true;
// 				}
// 			}
//
// 			return false;
// 		}
// 	}
//
