/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode true_head;
    public boolean isSubPath(ListNode head, TreeNode root) {
        dfs(root,head);
        return ans;
    }
    private boolean path(ListNode head,TreeNode root){
        if(head==null)return true;
        if(root==null)return false;
        if(head.val!=root.val)return false;
        return path(head.next,root.left)||path(head.next,root.right);
    }
    boolean ans=false;
    private void dfs(TreeNode root,ListNode head){
        if(root==null || head==null)return;
        if(path(head,root)){ans=true;return;}
        dfs(root.left,head);
        dfs(root.right,head);
    }
}