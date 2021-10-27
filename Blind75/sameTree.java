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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        pStack.push(p);
        qStack.push(q);

        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode pPtr = pStack.pop();
            TreeNode qPtr = qStack.pop();
            if (pPtr.val != qPtr.val) return false;

            if (pPtr.left != null) pStack.push(pPtr.left);
            if (qPtr.left != null) qStack.push(qPtr.left);
            if (pStack.size() != qStack.size()) return false;

            if (pPtr.right != null) pStack.push(pPtr.right);
            if (qPtr.right != null) qStack.push(qPtr.right);
            if (pStack.size() != qStack.size()) return false;
        }

        return pStack.size() == qStack.size();
    }
}
