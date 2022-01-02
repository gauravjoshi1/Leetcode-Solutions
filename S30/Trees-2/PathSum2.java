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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (root == null) return res;
        helper(root, targetSum, res, path);

        return res;
    }

    private void helper(TreeNode ptr, int t, List<List<Integer>> res, List<Integer> path) {
        if (ptr == null) return;

        t = t - ptr.val;
        path.add(ptr.val);

        if (ptr.left == null && ptr.right == null && t == 0) {
            res.add(new ArrayList<>(path));
        }

        helper(ptr.left, t, res, new ArrayList<>(path));
        helper(ptr.right, t, res, new ArrayList<>(path));

    }
}
