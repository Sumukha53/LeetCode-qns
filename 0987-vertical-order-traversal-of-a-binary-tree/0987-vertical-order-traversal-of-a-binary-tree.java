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
    class Pair{
        int val,v;
        Pair(int val,int v){
            this.val=val;
            this.v=v;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        temp=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        dfs_(root,0);
        for(int i=0;i<=mx_l-mn_l;i++){
        ans.add(new ArrayList<>());
        temp.add(new ArrayList<>());
        }
        dfs(root,0,0);
        
        for(List<Pair>l:temp){
            Collections.sort(l,(a,b)->{
            if(a.v==b.v)return Integer.compare(a.val,b.val);
            return Integer.compare(a.v,b.v);
        });}
        
        for(int i=0;i<temp.size();i++){
            for(int j=0;j<temp.get(i).size();j++){
                ans.get(i).add(temp.get(i).get(j).val);
            }
        }
        return ans;
    }
    List<List<Pair>>temp;
    private void dfs(TreeNode root,int v,int h){
        if(root==null)return;
        temp.get(h-mn_l).add(new Pair(root.val,v));
        dfs(root.left,v+1,h-1);
        dfs(root.right,v+1,h+1);
    }
    int mx_l=Integer.MIN_VALUE;
    int mn_l=Integer.MAX_VALUE;
    private void dfs_(TreeNode root,int h){
        if(root==null)return;
        mx_l=Math.max(mx_l,h);
        mn_l=Math.min(mn_l,h);
        dfs_(root.left,h-1);
        dfs_(root.right,h+1);
    }
}