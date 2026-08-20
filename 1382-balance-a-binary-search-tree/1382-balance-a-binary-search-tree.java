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
    List<TreeNode>l;
    public TreeNode balanceBST(TreeNode root) {
        l=new ArrayList<>();
        inOrder(root);
        return bst(l,0,l.size()-1);
    }
    private void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        l.add(root);
        inOrder(root.right);
        return;
    }
    private TreeNode bst(List<TreeNode>lst,int l,int r){
        if(l>r)return null;
        int m=(l+r)/2;
        TreeNode curr=lst.get(m);
        curr.left=bst(lst,l,m-1);
        curr.right=bst(lst,m+1,r);
        return curr;
    }
}