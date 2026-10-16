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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        m=new HashMap<>();
        ans=new ArrayList<>();
        dfs(root);
        return ans;
    }
    List<TreeNode>ans;
    HashMap<String,Integer>m;
    private String dfs(TreeNode root){
        if(root==null)return "";
        String curr=root.val+" "+dfs(root.left)+" "+dfs(root.right);
        if(m.containsKey(curr) && m.get(curr)==1){ans.add(root);}
        m.put(curr,m.getOrDefault(curr,0)+1);
        return curr;
    }
}