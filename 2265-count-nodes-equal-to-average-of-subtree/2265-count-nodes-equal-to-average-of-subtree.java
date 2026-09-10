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
        m=new HashMap<>();
        dfs(root);
        avg(root);
        return ans;
    }
    int ans=0;
    private int avg(TreeNode root){
        if(root==null)return 0;
        int left_sum=root.val+avg(root.left);
        int right_sum=root.val+avg(root.right);
        if(root.val==(left_sum+right_sum-root.val)/m.get(root))ans++;
        return left_sum+right_sum-root.val;
    }
    HashMap<TreeNode,Integer>m;
    private int dfs(TreeNode root){
        if(root==null)return 0;
        int temp=1+dfs(root.left)+dfs(root.right);
        m.put(root,temp);
        return temp;
    }
}