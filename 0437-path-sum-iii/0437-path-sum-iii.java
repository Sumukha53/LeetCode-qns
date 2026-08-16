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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer>m=new HashMap<>();
        m.put(0L,1);
        dfs(root,targetSum,0L,m);

        return ans;
    }
    int ans=0;
    private void dfs(TreeNode root,long t,long sm,HashMap<Long,Integer>m){
        if(root==null)return;
        ans+=m.getOrDefault(sm+root.val-t,0);
        m.put(sm+root.val,m.getOrDefault(sm+root.val,0)+1);
        dfs(root.left,t,sm+root.val,m);
        dfs(root.right,t,sm+root.val,m);
        m.put(sm+root.val,m.getOrDefault(sm+root.val,0)-1);

    }
}