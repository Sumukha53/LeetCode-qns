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
    HashMap<TreeNode,Integer>m=new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        getSum(root);
        HashMap<Integer,Integer>sumCnt=new HashMap<>();
        int mxcnt=0;
        for(int i:m.values()){sumCnt.put(i,sumCnt.getOrDefault(i,0)+1);mxcnt=Math.max(mxcnt,sumCnt.get(i));}
        int cnt=0;
        for(int i:sumCnt.values())if(i==mxcnt)cnt++;
        int[] ans=new int[cnt];
        int j=0;
        for (Map.Entry<Integer, Integer> e : sumCnt.entrySet()){
            if(e.getValue()==mxcnt)ans[j++]=e.getKey();
        }
        return ans;
    }
    private int getSum(TreeNode root){
        if(root==null)return 0;
        m.put(root,root.val+getSum(root.left)+getSum(root.right));
        return m.get(root);
    }
}