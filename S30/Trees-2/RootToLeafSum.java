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

// iterative solution
class Solution {
    Stack<Integer> sumStack = new Stack<>();
    Stack<TreeNode> path = new Stack<>();

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        traverseLeft(root, 0);

        while (!path.isEmpty()) {
            TreeNode ptr = path.pop();
            int currSum = sumStack.pop();

            if (ptr.left == null && ptr.right == null && currSum == targetSum) {
                return true;
            }

            traverseLeft(ptr.right, currSum);
        }

        return false;
    }

    private void traverseLeft(TreeNode ptr, int currSum) {
        while (ptr != null) {
            currSum = currSum + ptr.val;
            sumStack.push(currSum);
            path.push(ptr);
            ptr = ptr.left;
        }
    }
}
