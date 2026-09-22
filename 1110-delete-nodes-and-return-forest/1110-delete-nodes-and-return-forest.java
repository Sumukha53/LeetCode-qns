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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        s=new HashSet<>();
        for(int i:to_delete)s.add(i);
        ans=new ArrayList<>();
        postOrder(root);
        if(!s.contains(root.val))ans.add(root);
        if(s.contains(root.val)){
            if(root.left!=null)ans.add(root.left);
            if(root.right!=null)ans.add(root.right);
        }
        return ans;
    }
    HashSet<Integer>s;
    List<TreeNode>ans;
    private void postOrder(TreeNode root){
        if(root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        if(root.left!=null && s.contains(root.left.val)){
            if(root.left.left!=null)ans.add(root.left.left);
            if(root.left.right!=null)ans.add(root.left.right);
            root.left=null;
        }
        if(root.right!=null && s.contains(root.right.val)){
            if(root.right.left!=null)ans.add(root.right.left);
            if(root.right.right!=null)ans.add(root.right.right);
            root.right=null;
        }
        
    }
}