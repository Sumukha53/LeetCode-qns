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
    private int max_ind(int[] nums,int i,int j){
        int mx=-1;
        int ans=0;
        for(int x=i;x<=j;x++){
            if(nums[x]>mx){
                mx=nums[x];
                ans=x;
            }
        }
        return ans;
    }
    private TreeNode divAcon(int[] nums,int s,int e){
        if(s>e)return null;
        int mx_ind=max_ind(nums,s,e);
        TreeNode root=new TreeNode(nums[mx_ind]);
        root.left=divAcon(nums,s,mx_ind-1);
        root.right=divAcon(nums,mx_ind+1,e);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return divAcon(nums,0,nums.length-1);
    }

}