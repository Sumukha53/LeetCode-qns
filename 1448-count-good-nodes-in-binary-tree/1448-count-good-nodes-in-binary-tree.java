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
    public int goodNodes(TreeNode root) {
        func(root,root.val);
        return ans;
    }
        int ans=0;
    private void func(TreeNode root,int mx){
        if(root==null)return;
        if(root.val>=mx){
            mx=root.val;
            ans++;
        }
        func(root.left,mx);
        func(root.right,mx);
    }
}