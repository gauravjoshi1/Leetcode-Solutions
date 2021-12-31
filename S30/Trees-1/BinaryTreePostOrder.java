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

// iterative
class Solution {
	Stack<TreeNode> postStack = new Stack<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();


        if (root == null) return res;

        traverse(root);
        TreeNode visited = null;

        while (!postStack.isEmpty()) {
            TreeNode ptr = postStack.peek();

            if (ptr.right != null && ptr.right != visited) {
                traverse(ptr.right);
            } else {
                visited = postStack.pop();
                res.add(visited.val);
            }
        }

        return res;
    }

    private void traverse(TreeNode ptr) {
        while (ptr != null) {
            postStack.push(ptr);
            ptr = ptr.left;
        }
    }
}
