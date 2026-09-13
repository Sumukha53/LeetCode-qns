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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        list=new ArrayList<>();
        inOrder(root);
        List<List<Integer>>ans=new ArrayList<>();
        for(int q:queries){
            int pos=binary_search(list,q);
            if(pos==list.size()){
                List<Integer>temp=new ArrayList<>();
                temp.add(list.get(pos-1));
                temp.add(-1);
                ans.add(temp);
            }
            else if(pos==0 && list.get(pos)!=q){
                List<Integer>temp=new ArrayList<>();
                temp.add(-1);
                temp.add(list.get(0));
                ans.add(temp);
            }
            else{
                if(list.get(pos)==q){
                List<Integer>temp=new ArrayList<>();
                temp.add(list.get(pos));
                temp.add(list.get(pos));
                ans.add(temp);
                }
                else{
                List<Integer>temp=new ArrayList<>();
                temp.add(list.get(pos-1));
                temp.add(list.get(pos));
                ans.add(temp);
                }
            }
        }
        return ans;

    }
    private int binary_search(List<Integer>list,int t){
        int i=0,j=list.size();
        while(i<j){
            int m=(i+j)>>1;
            if(list.get(m)<t)i=m+1;
            else j=m;
        }
        return j;
    }
    List<Integer>list;
    private void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}