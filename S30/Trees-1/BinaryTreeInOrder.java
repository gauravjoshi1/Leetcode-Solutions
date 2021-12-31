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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

       return inorderHelper(root, res);
    }

    private List<Integer> inorderHelper(TreeNode ptr, List<Integer> res) {
        if (ptr == null) return res;

        // recurse the left sub tree
        res = inorderHelper(ptr.left, res);

        // add the root
        res.add(ptr.val);

        // recurse the right sub-tree
        res = inorderHelper(ptr.right, res);
        return res;
    }
}

//iterative solution
class Solution {
	Stack<TreeNode> inorderStack = new Stack<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		if (root == null) return res;
		traverseLeft(root);

		while (!inorderStack.isEmpty()) {
			TreeNode ptr = inorderStack.pop();
			res.add(ptr.val);

			if (ptr.right != null) {
				traverseLeft(ptr.right);
			}
		}

        return res;

	}

	private void traverseLeft(TreeNode ptr) {
		while (ptr != null) {
			inorderStack.push(ptr);
			ptr = ptr.left;
		}
	}
}
