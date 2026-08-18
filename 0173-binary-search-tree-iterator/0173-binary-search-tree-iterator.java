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
    Stack<Integer>st;
    private void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.right);
        st.push(root.val);
        inOrder(root.left);
        return;
    }
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        inOrder(root);
    }
    
    public int next() {
        return st.pop();
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */