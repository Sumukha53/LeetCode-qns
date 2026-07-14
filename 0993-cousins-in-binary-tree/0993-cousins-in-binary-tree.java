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
    HashMap<Integer,Integer>m;
    public boolean isCousins(TreeNode root, int x, int y) {
        m=new HashMap<>();
        m.put(root.val,0);
        dfs(root.left,0);dfs(root.right,0);
        if(m.get(x)==0 || m.get(y)==0 || m.get(x)==m.get(y))return false;
        while(x!=0 && y!=0){
            if(m.get(x)==m.get(y))return true;
            x=m.get(x);y=m.get(y);
        }
        return false;
    }
    private void dfs(TreeNode node,int prev){
        if(node==null)return;
        dfs(node.left,node.val);
        m.put(node.val,prev);
        dfs(node.right,node.val);
    }
}