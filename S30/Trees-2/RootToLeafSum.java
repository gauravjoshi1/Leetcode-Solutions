/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// recursive solution
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
		return helper(ptr, targetSum, 0);
    }

    private boolean helper(TreeNode ptr, int target, int currSum) {
		if (ptr == null) return false;
		currSum = currSum + ptr.val;

		if (ptr.left == null && ptr.right == null) return currSum == target;
		return helper(ptr.left, target, currSum) || helper(ptr.right, target, currSum);
	}
}

