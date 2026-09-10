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
    public int averageOfSubtree(TreeNode root) {
        avg(root);
        return ans;
    }
    int ans=0;
    private int[] avg(TreeNode root){
        if(root==null)return new int[2];
        int[] l=avg(root.left);
        int[] r=avg(root.right);
        int[] left=new int[]{root.val+l[0],1+l[1]};
        int[] right=new int[]{root.val+r[0],1+r[1]};
        if(root.val==(left[0]+right[0]-root.val)/(left[1]+right[1]-1))ans++;
        return new int[]{left[0]+right[0]-root.val,left[1]+right[1]-1};
    }
}