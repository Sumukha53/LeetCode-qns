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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode>q=new LinkedList<>();
        PriorityQueue<Long>pq=new PriorityQueue<>(
            (a,b)->Long.compare(a,b)
        );
        q.offer(root);
        int lvl=1;
        while(!q.isEmpty()){
            int n=q.size();
            long sum=0L;
            while(n-->0){
                TreeNode peek=q.poll();
                if(peek.left!=null)q.offer(peek.left);
                if(peek.right!=null)q.offer(peek.right);
                sum+=peek.val;
            }
            pq.offer(sum);
            if(pq.size()>k)pq.poll();
            lvl++;
        }
        return pq.size()==k?pq.poll():-1L;
    }
}