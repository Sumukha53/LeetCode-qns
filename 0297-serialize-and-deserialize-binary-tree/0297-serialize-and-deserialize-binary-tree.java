/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "N";
        return root.val+" "+serialize(root.left)+" "+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String>q=new LinkedList(Arrays.asList(data.split(" ")));
        return helper(q);
    }
    private TreeNode helper(Queue<String>q){
        String peek=q.poll();
        if(peek.equals("N"))return null;
        TreeNode curr=new TreeNode(Integer.valueOf(peek));
        curr.left=helper(q);
        curr.right=helper(q);
        return curr;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));