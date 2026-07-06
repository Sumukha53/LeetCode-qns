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
    public int maxLevelSum(TreeNode root) {
        HashMap<Integer,Integer>m=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        int max=Integer.MIN_VALUE;
        int lvl=0;
        int ans=0;
        while(!q.isEmpty()){
            int n=q.size();
            int sum=0;
            lvl++;
            while(n-->0){
                TreeNode temp=q.poll();
                sum+=temp.val;
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
            if(sum>max){max=sum;ans=lvl;}
        }
        return ans;
    }
}