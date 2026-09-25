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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dep=depth(root);
        int cnt=count(root,dep,0);
        dfs(root,cnt,0);
        return ans;
    }
    int dep=0;
    TreeNode ans=null;
    private int dfs(TreeNode root,int deepcnt,int currdep){
        if(currdep==dep)return 1;
        if(root==null)return 0;
        int tot=dfs(root.left,deepcnt,currdep+1)+dfs(root.right,deepcnt,currdep+1);
        if(tot==deepcnt && ans==null)ans=root;
        return tot;
    }
    private int depth(TreeNode root){
        return root==null?0:Math.max(1+depth(root.left),1+depth(root.right));
    }
    private int count(TreeNode root,int dep,int currdep){
        if(currdep==dep)return 1;
        if(root==null)return 0;
        return count(root.left,dep,currdep+1)+count(root.right,dep,currdep+1);
    }
}