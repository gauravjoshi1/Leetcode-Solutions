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
    public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) return new ArrayList<>();

        Queue<TreeNode> levelQ = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        levelQ.add(root);

        while (!levelQ.isEmpty()) {
			int len = levelQ.size();
			List<Integer> levelArr = new ArrayList<>();

			for (int i = 0; i < len; i++) {
				TreeNode ptr = levelQ.poll();
				levelArr.add(ptr.val);

				if (ptr.left != null) {
					levelQ.add(ptr.left);
				}

				if (ptr.right != null) {
					levelQ.add(ptr.right);
				}
			}

			if (!levelArr.isEmpty()) {
				res.add(levelArr);
			}
        }

        return res;
    }
}
