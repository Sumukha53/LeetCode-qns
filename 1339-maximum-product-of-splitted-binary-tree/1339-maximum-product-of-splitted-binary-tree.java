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
    public int maxProduct(TreeNode root) {
        sum=dfs(root);
        dfs_(root);
        return (int)(ans%(1_000_000_000+7));
    }
    long ans=0,sum=0;
    private long dfs(TreeNode root){
        if(root==null)return 0;
        return root.val+dfs(root.right)+dfs(root.left);
    }
    private long dfs_(TreeNode root){
        if(root==null)return 0;
        long left=root.val+dfs_(root.left);
        long right=root.val+dfs_(root.right);
        long subtree=left+right-root.val;
        ans=Math.max(ans,(sum-subtree)*subtree);
        return subtree;
    }
}