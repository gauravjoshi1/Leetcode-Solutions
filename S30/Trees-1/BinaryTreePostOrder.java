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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        return postorderHelper(root, res);
    }

    private List<Integer> postorderHelper(TreeNode ptr, List<Integer> res) {
        if (ptr == null) return res;

        res = postorderHelper(ptr.left, res);
        res = postorderHelper(ptr.right, res);

        res.add(ptr.val);

        return res;
    }
}
