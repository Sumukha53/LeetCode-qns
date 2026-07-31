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
    public int kthSmallest(TreeNode root, int k) {
        kk=k-1;
        inOrder(root);
        return ans;
    }
    int kk=0,ans=0;
    private void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        if(kk==0)ans=root.val;
        kk--;
        inOrder(root.right);
        return;
    }
}