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

    // recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> preorderArr = new ArrayList<>();
        return traverse(root, preorderArr);
    }

    private List<Integer> traverse(TreeNode ptr, List<Integer> preorderArr) {
        if (ptr == null) return preorderArr;

        preorderArr.add(ptr.val);

        preorderArr = traverse(ptr.left, preorderArr);
        preorderArr = traverse(ptr.right, preorderArr);

        return preorderArr;
    }
}
