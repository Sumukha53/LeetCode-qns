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
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        ListNode nxt;
        int sz=0;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
            sz++;
        }
        head=prev;
        Stack<Integer>st=new Stack<>();
        curr=head;
        int[] ans=new int[sz];
        int ind=sz-1;
        while(curr!=null){
            while(!st.isEmpty() && st.peek()<=curr.val)st.pop();
            ans[ind--]=!st.isEmpty()?st.peek():0;
            st.push(curr.val);
            curr=curr.next;
        }
        return ans;
    }
}