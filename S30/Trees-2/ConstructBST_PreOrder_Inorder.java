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
    HashMap<Integer, Integer> inorderValueToIndex = new HashMap<>();
    int preorderRoot;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0
            || inorder == null || inorder.length == 0) return null;

        preorderRoot = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderValueToIndex.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int leftSubTree, int rightSubTree) {
        if (leftSubTree > rightSubTree) return null;
        int rootValue = preorder[preorderRoot++];
        int rootIndexInorder = inorderValueToIndex.get(rootValue);


        TreeNode root = new TreeNode(rootValue);

        root.left = helper(preorder, leftSubTree, rootIndexInorder - 1);
        root.right = helper(preorder, rootIndexInorder + 1, rightSubTree);

        return root;
    }
}
