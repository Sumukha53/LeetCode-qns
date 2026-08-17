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
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)return 0;
        s=new HashSet<>();
        dfs(root);
        return --ans;
    }
    HashSet<TreeNode>s;
    private int uni(TreeNode root,int prev){
        if(root==null)return 0;
        if(root.val!=prev){
            return 0;
        }
        s.add(root);
        int left=1+uni(root.left,root.val);
        int right=1+uni(root.right,root.val);
        ans=Math.max(ans,left+right-1);
        return Math.max(left,right);
    }
    int ans=0;
    private void dfs(TreeNode root){
        if(root==null)return;
        if(!s.contains(root)){
            int l=uni(root.left,root.val);
            int r=uni(root.right,root.val);
            ans=Math.max(uni(root,root.val),ans);
        }
        dfs(root.left);
        dfs(root.right);
    }
}