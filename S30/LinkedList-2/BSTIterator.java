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
class BSTIterator {
    Stack<TreeNode> bStack;
    
    public BSTIterator(TreeNode root) {
        bStack = new Stack<>();
        
        // push the left side of the tree into the Stack
        leftTraverse(root);
    }
    
    public int next() {
        TreeNode currNode = bStack.pop();
        
        if (currNode.right != null) {
			// O(n) cost for pushing the entire right side in worst cases 
            leftTraverse(currNode.right);    
        }
        
        return currNode.val;
    }
    
    public boolean hasNext() {
        return !bStack.isEmpty();
    }
    
    private void leftTraverse(TreeNode ptr) {
        while (ptr != null) {
            bStack.push(ptr);
            ptr = ptr.left;
        }
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */