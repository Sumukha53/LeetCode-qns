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
    public int maxSumBST(TreeNode root) {
        res=0;
        dfs_(root);
        return res;
    }
    int res;
    private int[] dfs_(TreeNode root){
        if(root==null)return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0,1};
        int[] left=dfs_(root.left);
        int[] right=dfs_(root.right);
        int[] ans;
        if(left[3]==1 && right[3]==1 && root.val>left[1] && root.val<right[0]){
            ans=new int[]{Math.min(root.val,left[0]),Math.max(root.val,right[1]),left[2]+right[2]+root.val,1};
            res=Math.max(res,ans[2]);
        }
        else ans=new int[]{0,0,0,0};
        return ans;
        
    }
}