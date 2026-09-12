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
    public void flatten(TreeNode root) {
        if(root==null)return;
        st=new Stack<>();
        flat(root);
        st.pop();
        TreeNode top=root;
        root.left=null;
        while(!st.isEmpty()){
            top.right=st.pop();
            top=top.right;
            top.left=null;
        }
    }
    Stack<TreeNode>st;
    private void flat(TreeNode root){
        if(root==null)return;
        flat(root.right);
        flat(root.left);
        st.push(root);
    }
}