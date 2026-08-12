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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode temp=new TreeNode(val);
            temp.left=root;
            return temp;
        }
        return add(root,val,depth,1);
    }
    private TreeNode add(TreeNode root,int val, int dep,int curr){
        if(root==null)return root;
        if(curr==dep-1){
            TreeNode temp=new TreeNode(val);
            TreeNode l=root.left;
            TreeNode r=root.right;
            TreeNode l1,r1;
            l1=root.left=new TreeNode(val);
            r1=root.right=new TreeNode(val);
            l1.left=add(l,val,dep,curr+1);
            r1.right=add(r,val,dep,curr+1);
        }
        else{
            root.left=add(root.left,val,dep,curr+1);
            root.right=add(root.right,val,dep,curr+1);
        }
        return root;
    }
}