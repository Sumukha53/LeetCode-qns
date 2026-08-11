/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)return root;
        Queue<Node>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            Node prev=null;
            while(n-->0){
                Node top=q.poll();
                if(prev!=null){
                    prev.next=top;
                }
                prev=top;
                if(top.left!=null)q.add(top.left);
                if(top.right!=null)q.add(top.right);
            }
        }
        return root;
    }
}