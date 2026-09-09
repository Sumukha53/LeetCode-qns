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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int dep=depth(root);
        depth(root,dep,0);
        int x=dfs(root,dep,0);
        return ans;
    }
    private int depth(TreeNode root){
        if(root==null)return 0;
        int d=1+Math.max(depth(root.left),depth(root.right));
        return d;
    }
    int mx_cnt=0;
    private void depth(TreeNode root,int mxd,int d){
        if(root==null)return ;
        depth(root.left,mxd,d+1);
        depth(root.right,mxd,d+1);
        if(mxd==d+1)mx_cnt++;
    }
    TreeNode ans=null;
    private int dfs(TreeNode root,int depth,int curr_depth){
        if(curr_depth==depth){return 1;}
        if(root==null)return 0;
        int l=dfs(root.left,depth,curr_depth+1);
        int r=dfs(root.right,depth,curr_depth+1);
        if(l+r==2*mx_cnt && ans==null)ans=root;
        return l+r;
    }
}