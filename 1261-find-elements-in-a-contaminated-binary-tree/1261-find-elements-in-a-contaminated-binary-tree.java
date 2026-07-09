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
class FindElements {
    HashSet<Integer>s=new HashSet<>();
    public FindElements(TreeNode root) {
        root.val=0;
        s.add(0);
        func(root);
    }
    private void func(TreeNode root){
        if(root==null)return;
        if(root.left!=null){
            root.left.val=root.val*2+1;
            s.add(root.left.val);
            func(root.left);
        }
        if(root.right!=null){
            root.right.val=root.val*2+2;
            s.add(root.right.val);
            func(root.right);
        }
        return;
    }
    
    public boolean find(int target) {
        return s.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */