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
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        int n=l.size();
        TreeNode ans=l.get(0);
        TreeNode node=ans;
        for(int i=1;i<n;i++){
            node.right=l.get(i);
            node.left=null;
            node=node.right;
        }
        node.left=null;
        return ans;
    }
    List<TreeNode>l=new ArrayList<>();
    private void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        l.add(root);
        inOrder(root.right);
    }
}