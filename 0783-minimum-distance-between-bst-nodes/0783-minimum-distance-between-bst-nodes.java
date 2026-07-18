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
    public int minDiffInBST(TreeNode root) {
        mind(root);
        return (int)ans;
    }
    long ans=Long.MAX_VALUE;
    int prev=Integer.MAX_VALUE;
    private void mind(TreeNode root){
        if(root==null)return;
        mind(root.left);
        ans=Math.min(ans,Math.abs(root.val-prev));
        prev=root.val;
        mind(root.right);
        }
    
}