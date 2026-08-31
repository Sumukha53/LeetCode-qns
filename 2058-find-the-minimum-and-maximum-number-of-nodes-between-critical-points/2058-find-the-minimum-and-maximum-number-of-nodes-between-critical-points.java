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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int ind=0;
        ListNode curr=head;
        int prev=-1;
        int mindist=Integer.MAX_VALUE;
        int maxdist=Integer.MIN_VALUE;
        ListNode prevnode=curr;
        curr=curr.next;
        int first=-1;
        int cnt=0;
        while(curr!=null){
            if(curr.next!=null && ((prevnode.val>curr.val && curr.next.val>curr.val) || (prevnode.val<curr.val && curr.next.val<curr.val))){
                if(prev!=-1){
                    mindist=Math.min(mindist,ind-prev);
                }
                prev=ind;
                if(first==-1)first=ind;
                cnt++;
            }
            ind++;
            prevnode=curr;
            curr=curr.next;
        }
        if(cnt<2)return new int[]{-1,-1};
        return new int[]{mindist,prev-first};
    }
}