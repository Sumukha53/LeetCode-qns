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
    public TreeNode pruneTree(TreeNode root) {
        prune(root);
        if(root.val==0 && root.left==null && root.right==null)return null;
        return root;
    }
    private int prune(TreeNode root){
        if(root==null)return 0;
        int left=root.val+prune(root.left);
        int right=root.val+prune(root.right);
        if(left==0 || (left==1 && root.val==1))root.left=null;
        if(right==0 || (right==1 && root.val==1))root.right=null;
        return left+right;
    }
}