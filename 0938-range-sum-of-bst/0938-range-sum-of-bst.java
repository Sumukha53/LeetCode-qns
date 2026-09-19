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
    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root,low,high);
        return ans;
    }
    int ans=0;
    private void inOrder(TreeNode root,int l,int h){
        if(root==null)return;
        inOrder(root.left,l,h);
        if(root.val>=l && root.val<=h)ans+=root.val;
        inOrder(root.right,l,h);
    }
}