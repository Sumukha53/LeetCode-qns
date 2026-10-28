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
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root);
        return ans;
    }
    int ans=0;
    int mask=0;
    private void dfs(TreeNode root){
        if(root==null)return;
        mask^=(1<<(root.val-1));
        dfs(root.left);
        dfs(root.right);
        if(root.left==null && root.right==null){
            if((mask&(mask-1))==0)ans++;
        }
        mask^=(1<<(root.val-1));

    }
}