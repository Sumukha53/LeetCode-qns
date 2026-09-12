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
class CBTInserter {
    Queue<TreeNode>q=new LinkedList<>();
    TreeNode rootnode;
    public CBTInserter(TreeNode root) {
        rootnode=root;
        Queue<TreeNode>bfs=new LinkedList<>();
        bfs.add(rootnode);
        while(!bfs.isEmpty()){
                TreeNode top=bfs.poll();
                if(top.left==null || top.right==null){
                    q.offer(top);
                }
                if(top.left!=null)bfs.add(top.left);
                if(top.right!=null)bfs.add(top.right);
        }
    }
    
    public int insert(int val) {
        TreeNode top=q.peek();
        if(top.left==null){
            top.left=new TreeNode(val);
            q.add(top.left);
        }
        else if(top.right==null){
            top.right=new TreeNode(val);
            q.add(top.right);
        }
        if(top.left!=null && top.right!=null)q.poll();
        return top.val;
    }
    
    public TreeNode get_root() {
        return rootnode;
    }
    
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */