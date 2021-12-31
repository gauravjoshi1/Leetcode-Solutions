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


// iterative solution
class Solution {
    Stack<TreeNode> preorderStack = new Stack<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> preorderArr = new ArrayList<>();
        traverseLeft(root, preorderArr);

        while (!preorderStack.isEmpty()) {
            TreeNode ptr = preorderStack.pop();
            traverseLeft(ptr.right, preorderArr);
        }

        return preorderArr;
    }

    private void traverseLeft(TreeNode ptr, List<Integer> preorderArr) {
        while (ptr != null) {
            preorderArr.add(ptr.val);
            preorderStack.push(ptr);
            ptr = ptr.left;
        }
    }
}
