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

enum Index {
	GOOD, BAD, UNKNOWN
}

class Solution {
	Index[] memoTable;

	public boolean canJump(int[] nums) {
		memoTable = new Index[nums.length];

		for (int i = 0; i < nums.length; i++) {
			memoTable[i] = Index.UNKNOWN;
		}

		memoTable[memoTable.length - 1] = Index.GOOD;

		for (int i = nums.length - 2; i >= 0; i--) {
			int longestJump = Math.min(nums[i] + i, nums.length - 1);

			for (int j = i + 1; j <= longestJump; j++) {
				if (nums[j] == Index.GOOD) {
					nums[i] = Index.GOOD;
					break;
				}
			}
		}

		return nums[0] == Index.GOOD;
	}

}
