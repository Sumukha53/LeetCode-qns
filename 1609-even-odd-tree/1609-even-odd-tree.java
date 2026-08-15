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
    public boolean isEvenOddTree(TreeNode root) {
        boolean lvl=true;
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            int prev=-1;
            while(n-->0){
                TreeNode peek=q.poll();
                System.out.println(peek.val);
                if(peek.left!=null)q.offer(peek.left);
                if(peek.right!=null)q.offer(peek.right);
                if(lvl){
                    if(prev>=peek.val)return false;
                    if(peek.val%2==0)return false;
                }
                else{
                    if(prev!=-1 && prev<=peek.val)return false;
                    if(peek.val%2==1)return false;
                }
                prev=peek.val;
            }
            lvl=!lvl;
        }
        return 0==0;
    }
}