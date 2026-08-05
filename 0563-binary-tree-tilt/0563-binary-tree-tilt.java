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
    int ans=0;
    public int findTilt(TreeNode root) {
        helper(root);
        return ans;
    }
    private int helper(TreeNode root){
        if(root==null)return 0;
        if(root.left==null && root.right==null)return root.val;
        int left=root.val+helper(root.left);
        int right=root.val+helper(root.right);
        ans+=Math.abs(left-right);
        return left+right-root.val;
    }
    
}