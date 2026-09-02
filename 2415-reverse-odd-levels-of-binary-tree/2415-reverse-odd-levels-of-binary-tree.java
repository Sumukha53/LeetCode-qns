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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        int lvl=0;
        List<TreeNode>lst=new ArrayList<>();
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                TreeNode curr=q.poll();
                if(curr.left!=null){q.offer(curr.left);q.offer(curr.right);}
                lst.add(curr);
            }
            if(lvl%2==1){
            int len=lst.size()-1,ind=0;
            while(ind<len){
                int temp=lst.get(ind).val;
                lst.get(ind).val=lst.get(len).val;
                lst.get(len).val=temp;
                ind++;len--;
            }
            }
            lst.clear();
            lvl++;
        }
        return root;
    }
}